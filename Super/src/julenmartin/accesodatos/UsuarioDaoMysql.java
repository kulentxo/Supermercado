package julenmartin.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import julenmartin.pojo.Usuario;

public class UsuarioDaoMysql implements DaoUsuario {
	final String URL = "jdbc:mysql://localhost:3306/supermercado?serverTimezone=UTC";
	final String USER = "root";
	final String PASS = "admin";

	final String SQL_SELECT = "SELECT * FROM usuarios";
	final String SQL_SELECT_ID = "SELECT * FROM usuarios WHERE id = ?";
	final String SQL_SELECT_EMAIL = "SELECT * FROM usuarios WHERE email = ?";

	final String SQL_INSERT = "INSERT INTO `supermercado`.`usuarios` (email, password) VALUES (?, ?)";
	final String SQL_UPDATE = "UPDATE usuarios SET email = ?, password = ? WHERE id = ?";
	final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de JDBC para MySQL", e);
		}
	}

	private UsuarioDaoMysql() {
	}

	private final static UsuarioDaoMysql INSTANCIA = new UsuarioDaoMysql();

	public static UsuarioDaoMysql getInstancia() {
		return INSTANCIA;
	}

	@Override
	public Iterable<Usuario> listar() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(SQL_SELECT);) {

			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			Usuario usuario;
			while (rs.next()) {
				usuario = new Usuario(rs.getString("email"), rs.getString("password"), rs.getLong("id"));

				usuarios.add(usuario);
			}
			return usuarios;
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido consultar la lista de usuarios", e);
		}
	}

	@Override
	public Usuario recuperar(Long id) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);) {

			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery();) {

				Usuario usuario = null;

				if (rs.next()) {
					usuario = new Usuario(rs.getString("email"), rs.getString("password"), rs.getLong("id"));
				}

				return usuario;
			}
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido recibir el usuario " + id, e);
		}
	}

	@Override
	public void crear(Usuario objeto) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_INSERT);) {

			ps.setString(1, objeto.getEmail());
			ps.setString(2, objeto.getPass());

			int numeroRegistrosAfectados = ps.executeUpdate();

			if (numeroRegistrosAfectados != 1) {
				throw new AccesoDatosException("Se han insertado " + numeroRegistrosAfectados + " registros");
			}

		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido insertar el usuario " + objeto, e);
		}

	}

	@Override
	public void modificar(Usuario objeto) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, objeto.getEmail());
			ps.setString(2, objeto.getPass());
			ps.setLong(3, objeto.getId());

			int numeroRegistrosAfectados = ps.executeUpdate();

			if (numeroRegistrosAfectados != 1) {
				throw new AccesoDatosException("Se han modificado " + numeroRegistrosAfectados + " registros");
			}

		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido modificar el usuario " + objeto, e);
		}
	}

	@Override
	public void eliminar(Long id) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {
			ps.setLong(1, id);

			int numeroRegistrosAfectados = ps.executeUpdate();

			if (numeroRegistrosAfectados != 1) {
				throw new AccesoDatosException("Se han borrado " + numeroRegistrosAfectados + " registros");
			}

		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido borrar el usuario " + id, e);
		}

	}

	@Override
	public Usuario obtenerPorEmail(String email) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_EMAIL);) {

			ps.setString(1, email);

			try (ResultSet rs = ps.executeQuery()) {
				Usuario usuario = null;

				if (rs.next()) {
					usuario = new Usuario(rs.getString("email"), rs.getString("password"), rs.getLong("id"));
				}

				return usuario;
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido recibir el usuario " + email, e);
		}
	}

}
