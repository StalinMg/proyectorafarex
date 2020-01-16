package proyectorafatex.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the parametros database table.
 * 
 */
@Entity
@Table(name="parametros")
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_parametro", unique=true, nullable=false)
	private Integer idParametro;

	@Column(name="correo_empresa", nullable=false, length=100)
	private String correoEmpresa;

	@Column(name="descuento_producto", nullable=false, length=2147483647)
	private String descuentoProducto;

	@Column(name="direccion_empresa", nullable=false, length=200)
	private String direccionEmpresa;

	@Column(name="nombre_empresa", nullable=false, length=100)
	private String nombreEmpresa;

	@Column(name="porcentaje_iva", nullable=false, precision=6)
	private BigDecimal porcentajeIva;

	@Column(name="ruc_empresa", nullable=false, length=15)
	private String rucEmpresa;

	@Column(name="telefono_empresa", nullable=false, length=15)
	private String telefonoEmpresa;

	public Parametro() {
	}

	public Integer getIdParametro() {
		return this.idParametro;
	}

	public void setIdParametro(Integer idParametro) {
		this.idParametro = idParametro;
	}

	public String getCorreoEmpresa() {
		return this.correoEmpresa;
	}

	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}

	public String getDescuentoProducto() {
		return this.descuentoProducto;
	}

	public void setDescuentoProducto(String descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}

	public String getDireccionEmpresa() {
		return this.direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public BigDecimal getPorcentajeIva() {
		return this.porcentajeIva;
	}

	public void setPorcentajeIva(BigDecimal porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}

	public String getRucEmpresa() {
		return this.rucEmpresa;
	}

	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	public String getTelefonoEmpresa() {
		return this.telefonoEmpresa;
	}

	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}

}