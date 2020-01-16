package proyectorafatex.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the factura_det database table.
 * 
 */
@Entity
@Table(name="factura_det")
@NamedQuery(name="FacturaDet.findAll", query="SELECT f FROM FacturaDet f")
public class FacturaDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_factura_det", unique=true, nullable=false)
	private Integer idFacturaDet;

	private Integer cantidad;

	@Column(name="precio_unitario_venta", precision=12, scale=2)
	private BigDecimal precioUnitarioVenta;

	//bi-directional many-to-one association to FacturaCab
	@ManyToOne
	@JoinColumn(name="numero_factura_factura_cab")
	private FacturaCab facturaCab;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto_producto")
	private Producto producto;

	public FacturaDet() {
	}

	public Integer getIdFacturaDet() {
		return this.idFacturaDet;
	}

	public void setIdFacturaDet(Integer idFacturaDet) {
		this.idFacturaDet = idFacturaDet;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitarioVenta() {
		return this.precioUnitarioVenta;
	}

	public void setPrecioUnitarioVenta(BigDecimal precioUnitarioVenta) {
		this.precioUnitarioVenta = precioUnitarioVenta;
	}

	public FacturaCab getFacturaCab() {
		return this.facturaCab;
	}

	public void setFacturaCab(FacturaCab facturaCab) {
		this.facturaCab = facturaCab;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}