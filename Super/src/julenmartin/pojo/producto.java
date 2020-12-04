package julenmartin.pojo;

import java.io.Serializable;

public class producto implements Serializable {

	private static final long serialVersionUID = 5452816664057554386L;
	int id;
	private float precio;
	private int cantidad;
	private int oferta;
	private String desc;

	public producto() {
		super();
		this.id = 0;
		this.precio = 0;
		this.cantidad = 0;
		this.desc = "";
		this.oferta = 0;
	}

	public producto(int id, float precio, int cantidad, int oferta, String desc) {
		this();
		this.id = id;
		this.precio = precio;
		this.cantidad = cantidad;
		this.oferta = oferta;
		this.desc = desc;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getOferta() {
		return oferta;
	}

	public void setOferta(int oferta) {
		this.oferta = oferta;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "producto [precio=" + precio + ", cantidad=" + cantidad + ", oferta=" + oferta + ", desc=" + desc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + id;
		result = prime * result + oferta;
		result = prime * result + Float.floatToIntBits(precio);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		producto other = (producto) obj;
		if (cantidad != other.cantidad)
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (id != other.id)
			return false;
		if (oferta != other.oferta)
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		return true;
	}

}
