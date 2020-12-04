package julenmartin.accesodatos;

import java.util.TreeMap;

import org.apache.commons.lang3.SerializationUtils;

import julenmartin.pojo.producto;

public class ProductoDaoTreeMap implements Dao<producto> {
	private ProductoDaoTreeMap() {
		producto p1 = new producto(1, 12, 4, 10, "Prueba");
		producto p2 = new producto(2, 20, 10, 0, "Ginebra");
		productos.put(1, p1);
		productos.put(2, p2);
		for (int id = 3; id <= 12; id++) {
			productos.put(id, new producto(id, 11 * id, 5 * id, 10, "descripcion" + id));
		}
	}

	private final static ProductoDaoTreeMap INSTANCIA = new ProductoDaoTreeMap();

	public static ProductoDaoTreeMap getInstancia() {
		return INSTANCIA;
	}

	private TreeMap<Integer, producto> productos = new TreeMap<Integer, producto>();

	public Iterable<producto> listar() {
		return productos.values();
	}

	public producto recuperar(int id) {
		return SerializationUtils.clone(productos.get(id));
	}

	public void crear(producto objeto) {
		int id = productos.lastKey() != null ? productos.lastKey() + 1 : 1;
		objeto.setId(id);
		productos.put(id, objeto);
	}

	public void modificar(producto objeto) {
		productos.put(objeto.getId(), objeto);
	}

	public void eliminar(int id) {
		productos.remove(id);
	}

}
