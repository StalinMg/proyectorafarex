package proyectorafatex.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@Table(name="empleado")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_empleado", unique=true, nullable=false)
	private Integer idEmpleado;

	@Column(nullable=false, length=100)
	private String apellido;

	@Column(length=10)
	private String cedula;

	@Column(length=20)
	private String celular;

	@Column(nullable=false, length=50)
	private String contrasenia;

	@Column(nullable=false, length=100)
	private String correo;

	@Column(nullable=false, length=200)
	private String direccion;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(length=20)
	private String telefono;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="id_rol_rol")
	private Rol rol;

	//bi-directional many-to-one association to FacturaCab
	@OneToMany(mappedBy="empleado")
	private List<FacturaCab> facturaCabs;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="empleado")
	private List<Producto> productos;

	public Empleado() {
	}

	public Integer getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<FacturaCab> getFacturaCabs() {
		return this.facturaCabs;
	}

	public void setFacturaCabs(List<FacturaCab> facturaCabs) {
		this.facturaCabs = facturaCabs;
	}

	public FacturaCab addFacturaCab(FacturaCab facturaCab) {
		getFacturaCabs().add(facturaCab);
		facturaCab.setEmpleado(this);

		return facturaCab;
	}

	public FacturaCab removeFacturaCab(FacturaCab facturaCab) {
		getFacturaCabs().remove(facturaCab);
		facturaCab.setEmpleado(null);

		return facturaCab;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setEmpleado(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setEmpleado(null);

		return producto;
	}

}