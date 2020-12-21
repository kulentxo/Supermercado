package julenmartin.accesodatos;

import julenmartin.pojo.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	Usuario obtenerPorEmail(String email);
}
