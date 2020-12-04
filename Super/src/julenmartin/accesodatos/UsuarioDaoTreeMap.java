package julenmartin.accesodatos;

import java.util.TreeMap;

import julenmartin.pojo.Usuario;

public class UsuarioDaoTreeMap {
	private UsuarioDaoTreeMap() {
		Usuario p1 = new Usuario("kulentxo@hotmail.com", "pass", 1);
		Usuario p2 = new Usuario("julenmartin.martin@gmail.com", "contra", 2);
		usuarios.put(1, p1);
		usuarios.put(2, p2);

	}

	private final static UsuarioDaoTreeMap INSTANCIA = new UsuarioDaoTreeMap();

	public static UsuarioDaoTreeMap getInstancia() {
		return INSTANCIA;
	}

	private TreeMap<Integer, Usuario> usuarios = new TreeMap<Integer, Usuario>();

	public Iterable<Usuario> listar() {
		return usuarios.values();
	}

	public Usuario recuperar(int id) {
		return usuarios.get(id);
	}

	public void crear(Usuario objeto) {
		int id = usuarios.lastKey() != null ? usuarios.lastKey() + 1 : 1;
		objeto.setId(id);
		usuarios.put(id, objeto);
	}

	public void modificar(Usuario objeto) {
		usuarios.put(objeto.getId(), objeto);
	}

	public void eliminar(int id) {
		usuarios.remove(id);
	}

	public Usuario validarEmail(String email) {
		for (Usuario u : usuarios.values()) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}

}
