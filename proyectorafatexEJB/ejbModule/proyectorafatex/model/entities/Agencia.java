package proyectorafatex.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the agencia database table.
 * 
 */
@Entity
@Table(name="agencia")
@NamedQuery(name="Agencia.findAll", query="SELECT a FROM Agencia a")
public class Agencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_agencia", unique=true, nullable=false)
	private Integer idAgencia;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(nullable=false, length=20)
	private String telefono;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="agencia")
	private List<Pedido> pedidos;

	public Agencia() {
	}

	public Integer getIdAgencia() {
		return this.idAgencia;
	}

	public void setIdAgencia(Integer idAgencia) {
		this.idAgencia = idAgencia;
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

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setAgencia(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setAgencia(null);

		return pedido;
	}

}