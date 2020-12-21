package julenmartin.accesodatos;

public interface Dao<T> {
	Iterable<T> listar();

	T recuperar(Long id);

	void crear(T objeto);

	void modificar(T objeto);

	void eliminar(Long id);
}
