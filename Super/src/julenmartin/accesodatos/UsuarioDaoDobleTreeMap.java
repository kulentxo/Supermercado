package julenmartin.accesodatos;

import java.util.TreeMap;

import julenmartin.pojo.Usuario;

public class UsuarioDaoDobleTreeMap {
	private UsuarioDaoDobleTreeMap() {
		Usuario p1 = new Usuario("kulentxo@hotmail.com", "pass", 1);
		Usuario p2 = new Usuario("julenmartin.martin@gmail.com", "contra", 2);
		usuarios.put(1, p1);
		usuariosEmail.put("kulentxo@hotmail.com", p1);
		usuarios.put(2, p2);
		usuariosEmail.put("julenmartin.martin@gmail.com", p2);

	}

	private final static UsuarioDaoDobleTreeMap INSTANCIA = new UsuarioDaoDobleTreeMap();

	public static UsuarioDaoDobleTreeMap getInstancia() {
		return INSTANCIA;
	}

	private TreeMap<Integer, Usuario> usuarios = new TreeMap<Integer, Usuario>();
	private TreeMap<String, Usuario> usuariosEmail = new TreeMap<String, Usuario>();

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
		usuariosEmail.put(objeto.getEmail(), objeto);
	}

	public void modificar(Usuario objeto) {
		usuarios.put(objeto.getId(), objeto);
		for (Usuario ue : usuariosEmail.values()) {
			if (ue.getId() == objeto.getId()) {
				usuariosEmail.put(objeto.getEmail(), objeto);
			}
		}
	}

	public void eliminar(int id) {
		usuarios.remove(id);
		usuariosEmail.remove(usuarios.get(id).getEmail());
	}

	public Usuario validarEmail(String email) {
		return usuariosEmail.get(email);
	}

}
