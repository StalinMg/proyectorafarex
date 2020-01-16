package proyectorafatex.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="pedido")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedido", unique=true, nullable=false)
	private Integer idPedido;

	@Column(name="ciudad_entrega", nullable=false, length=100)
	private String ciudadEntrega;

	@Column(name="descripcion_estado", length=100)
	private String descripcionEstado;

	@Column(name="direccion_entrega", nullable=false, length=2147483647)
	private String direccionEntrega;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrega_pedido", nullable=false)
	private Date fechaEntregaPedido;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pedido", nullable=false)
	private Date fechaPedido;

	@Column(name="pais_entrega", nullable=false, length=100)
	private String paisEntrega;

	//bi-directional many-to-one association to DetallePedido
	@OneToMany(mappedBy="pedido")
	private List<DetallePedido> detallePedidos;

	//bi-directional many-to-one association to Agencia
	@ManyToOne
	@JoinColumn(name="id_agencia_agencia")
	private Agencia agencia;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente_cliente")
	private Cliente cliente;

	public Pedido() {
	}

	public Integer getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public String getCiudadEntrega() {
		return this.ciudadEntrega;
	}

	public void setCiudadEntrega(String ciudadEntrega) {
		this.ciudadEntrega = ciudadEntrega;
	}

	public String getDescripcionEstado() {
		return this.descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public String getDireccionEntrega() {
		return this.direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public Date getFechaEntregaPedido() {
		return this.fechaEntregaPedido;
	}

	public void setFechaEntregaPedido(Date fechaEntregaPedido) {
		this.fechaEntregaPedido = fechaEntregaPedido;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getPaisEntrega() {
		return this.paisEntrega;
	}

	public void setPaisEntrega(String paisEntrega) {
		this.paisEntrega = paisEntrega;
	}

	public List<DetallePedido> getDetallePedidos() {
		return this.detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().add(detallePedido);
		detallePedido.setPedido(this);

		return detallePedido;
	}

	public DetallePedido removeDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().remove(detallePedido);
		detallePedido.setPedido(null);

		return detallePedido;
	}

	public Agencia getAgencia() {
		return this.agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}