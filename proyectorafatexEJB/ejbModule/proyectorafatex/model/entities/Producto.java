package proyectorafatex.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_producto", unique=true, nullable=false)
	private Integer idProducto;

	@Column(name="cantidad_existente", nullable=false, precision=6)
	private BigDecimal cantidadExistente;

	@Column(name="cantidad_minima", nullable=false)
	private Integer cantidadMinima;

	@Column(nullable=false, length=200)
	private String descripcion;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(name="precio_por_mayor", nullable=false, precision=7, scale=2)
	private BigDecimal precioPorMayor;

	@Column(name="precio_unitario", nullable=false, precision=6, scale=2)
	private BigDecimal precioUnitario;

	@Column(name="ruta_imagen", nullable=false, length=150)
	private String rutaImagen;

	@Column(nullable=false, length=10)
	private String tamanio;

	//bi-directional many-to-one association to DetallePedido
	@OneToMany(mappedBy="producto")
	private List<DetallePedido> detallePedidos;

	//bi-directional many-to-one association to FacturaDet
	@OneToMany(mappedBy="producto")
	private List<FacturaDet> facturaDets;

	//bi-directional many-to-one association to Color
	@ManyToOne
	@JoinColumn(name="id_color_color")
	private Color color;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="id_empleado_empleado")
	private Empleado empleado;

	public Producto() {
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public BigDecimal getCantidadExistente() {
		return this.cantidadExistente;
	}

	public void setCantidadExistente(BigDecimal cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}

	public Integer getCantidadMinima() {
		return this.cantidadMinima;
	}

	public void setCantidadMinima(Integer cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioPorMayor() {
		return this.precioPorMayor;
	}

	public void setPrecioPorMayor(BigDecimal precioPorMayor) {
		this.precioPorMayor = precioPorMayor;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getRutaImagen() {
		return this.rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public String getTamanio() {
		return this.tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public List<DetallePedido> getDetallePedidos() {
		return this.detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().add(detallePedido);
		detallePedido.setProducto(this);

		return detallePedido;
	}

	public DetallePedido removeDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().remove(detallePedido);
		detallePedido.setProducto(null);

		return detallePedido;
	}

	public List<FacturaDet> getFacturaDets() {
		return this.facturaDets;
	}

	public void setFacturaDets(List<FacturaDet> facturaDets) {
		this.facturaDets = facturaDets;
	}

	public FacturaDet addFacturaDet(FacturaDet facturaDet) {
		getFacturaDets().add(facturaDet);
		facturaDet.setProducto(this);

		return facturaDet;
	}

	public FacturaDet removeFacturaDet(FacturaDet facturaDet) {
		getFacturaDets().remove(facturaDet);
		facturaDet.setProducto(null);

		return facturaDet;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}