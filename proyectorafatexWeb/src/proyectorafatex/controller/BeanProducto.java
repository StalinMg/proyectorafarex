package proyectorafatex.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import proyectorafatex.model.entities.Color;
import proyectorafatex.model.entities.Empleado;
import proyectorafatex.model.entities.Producto;
import proyectorafatex.model.manager.ManagerProducto;



@Named
@SessionScoped
public class BeanProducto implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Producto> listaproducto;
	@EJB
	private ManagerProducto managerProducto;
	private int idproducto;
	private String nombre;
	private String descripcion;
	private BigDecimal existencia;
	private BigDecimal precioUnitario;
	private BigDecimal precioMayor;
	private String rutaImagen;
	private String tamanio;
	private int cantidadminima;
	private Empleado empleado;
	private Color color;
	private Producto producto;
	
	@PostConstruct
	public void inicializar() {
		listaproducto=managerProducto.findAllProductos();
	}
	
	public String actionInsertarProducto(){
		//Producto p= new Producto();
	//	p.setIdProducto(idproducto);
	//	p.setDescripcion(descripcion);
		//p.setCantidadExistente(existencia);
//		p.setNombre(nombre);
	//	p.setPrecioUnitario(precioUnitario);
	//	p.setPrecioPorMayor(precioMayor);
	//	p.setRutaImagen(rutaImagen);
	//	p.setTamanio(tamanio);
	//	p.setEmpleado(empleado);
	//	p.setColor(color);
		try {
			managerProducto.insertarProducto(producto);
			listaproducto=managerProducto.findAllProductos(); 
			producto =  new Producto();
			JSFUtil.crearMensajeINFO("Producto Ingresado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		
		
		try {
			managerProducto.insertarProducto(producto);
			listaproducto=managerProducto.findAllProductos();
			idproducto=0;
			descripcion="";
			existencia=null;
			nombre="";
			precioUnitario=null;
			precioMayor=null;
			tamanio="";
			rutaImagen="";
			color=null;
		   
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}
	
	public String actionEliminarProducto(Producto producto){
		try {
			managerProducto.eliminarProducto(producto.getIdProducto());
			listaproducto=managerProducto.findAllProductos();
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}
	
	public String actionCargarProducto(Producto producto){
		  idproducto = producto.getIdProducto();
			descripcion= producto.getDescripcion();
			existencia= producto.getCantidadExistente();
			nombre= producto.getNombre();
			precioUnitario= producto.getPrecioUnitario();
			precioMayor= producto.getPrecioPorMayor();
			rutaImagen= producto.getRutaImagen();
			tamanio= producto.getTamanio();
			empleado= producto.getEmpleado();
			color= producto.getColor();
		return "productos_update";
	}
	public String actionActualizarProducto(){
		Producto p= new Producto();
		p.setIdProducto(idproducto);
		p.setDescripcion(descripcion);
		p.setCantidadExistente(existencia);
		p.setNombre(nombre);
		p.setPrecioUnitario(precioUnitario);
		p.setPrecioPorMayor(precioMayor);
		p.setRutaImagen(rutaImagen);
		p.setTamanio(tamanio);
		p.setEmpleado(empleado);
		p.setColor(color);
		
		try {
			managerProducto.actualizarProducto(p);
			listaproducto=managerProducto.findAllProductos();
			//limpiamos las variables del formulario:
			idproducto=0;
			descripcion="";
			existencia=null;
			nombre="";
			precioUnitario=null;
			precioMayor=null;
			tamanio="";
			rutaImagen="";
			cantidadminima=0;
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		return "productos";
	}
	
	
	public List<Producto> getListaproducto() {
		return listaproducto;
	}
	public void setListaproducto(List<Producto> listaproducto) {
		this.listaproducto = listaproducto;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public BigDecimal getPrecioMayor() {
		return precioMayor;
	}
	public void setPrecioMayor(BigDecimal precioMayor) {
		this.precioMayor = precioMayor;
	}
	public String getRutaImagen() {
		return rutaImagen;
	}
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	public String getTamanio() {
		return tamanio;
	}
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
	public int getCantidadminima() {
		return cantidadminima;
	}
	public void setCantidadminima(int cantidadminima) {
		this.cantidadminima = cantidadminima;
	}

	public BigDecimal getExistencia() {
		return existencia;
	}

	public void setExistencia(BigDecimal existencia) {
		this.existencia = existencia;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

	
}
