package proyectorafatex.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the color database table.
 * 
 */
@Entity
@Table(name="color")
@NamedQuery(name="Color.findAll", query="SELECT c FROM Color c")
public class Color implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_color", unique=true, nullable=false)
	private Integer idColor;

	@Column(nullable=false, length=100)
	private String nombre;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="color")
	private List<Producto> productos;

	public Color() {
	}

	public Integer getIdColor() {
		return this.idColor;
	}

	public void setIdColor(Integer idColor) {
		this.idColor = idColor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setColor(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setColor(null);

		return producto;
	}

}