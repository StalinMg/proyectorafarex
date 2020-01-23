package proyectorafatex.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import proyectorafatex.model.entities.Empleado;
import proyectorafatex.model.manager.ManagerEmpleado;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped

public class BeanEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerEmpleado managerEmpleado;
	private List<Empleado> ListaEmpleados;
	private Empleado empleado;
	private boolean panelColapsado;
	private Empleado empleadoSeleccionado;
	private Number idempleado;
	
	@PostConstruct
	public void inicializar() {
		ListaEmpleados=managerEmpleado.findAllEmpleados();
		empleado=new Empleado();
		panelColapsado=true;
	}
	public void actionListenerInsertarEmpleado() {
		try {
			managerEmpleado.insertarEmpleado(empleado);
			ListaEmpleados=managerEmpleado.findAllEmpleados();
			empleado=new Empleado();
			JSFUtil.crearMensajeINFO("Producto Ingresado");;
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarEmpleado(Number idempleado) {
		managerEmpleado.eliminarEmpleado(idempleado);
		ListaEmpleados=managerEmpleado.findAllEmpleados();
		JSFUtil.crearMensajeINFO("Producto eliminado");
	}
	public void actionListenerSeleccionarEmpleado(Empleado empleado) {
		empleadoSeleccionado=empleado;
	}
	public void actionListenerActualizarEmpleado() {
		try {
			managerEmpleado.actualizarEmpleado(empleadoSeleccionado);
			ListaEmpleados=managerEmpleado.findAllEmpleados();
			JSFUtil.crearMensajeINFO("Datos actualizados");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerColapsadoPanel() {
		panelColapsado=!panelColapsado;
	}
	public List<Empleado> getListaEmpleados() {
		return ListaEmpleados;
	}
	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		ListaEmpleados = listaEmpleados;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public boolean isPanelColapsado() {
		return panelColapsado;
	}
	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	public Empleado getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}
	public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}
	public Number getIdempleado() {
		return idempleado;
	}
	public void setIdempleado(Number idempleado) {
		this.idempleado = idempleado;
	}
	

}
