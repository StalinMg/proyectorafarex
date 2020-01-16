package proyectorafatex.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import proyectorafatex.model.entities.Agencia;

import proyectorafatex.model.manager.managerAgencia;


@Named
@SessionScoped
public class BeanAgencia implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private managerAgencia manageragencia;
	private List<Agencia> listaAgencia;
	private Agencia agencia;
	private boolean panelColapsado;
	private Agencia agenciaSeleccionada;

	
	@PostConstruct
	public void inicializar() {
		listaAgencia=manageragencia.findAllAgencia();
		agencia= new Agencia();
		panelColapsado=true;
	}
	public void actionListenerInsertarAgencia() {
		try {
			manageragencia.insertarAgencia(agencia);
			listaAgencia= manageragencia.findAllAgencia();
			agencia=new Agencia();
			JSFUtil.crearMensajeINFO("Agencia Insertado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		
	}
	public void actionListenerEliminarAgencia(Number idagencia) {
		
		manageragencia.eliminarAgencia(idagencia);
		listaAgencia= manageragencia.findAllAgencia();
		JSFUtil.crearMensajeINFO("Agencia ELiminada");
		
		
	}
	public void actionListenerSeleccionarAgencia(Agencia agencia) {
		
		agenciaSeleccionada=agencia;
		
	}
	public void actionListenerActualizarAgencia() {
		try {
		manageragencia.actualizarAgencia(agenciaSeleccionada);
		listaAgencia= manageragencia.findAllAgencia();
		JSFUtil.crearMensajeINFO("Datos actualizados");
		}catch(Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
			
		}
		
		
	}
	public void actionListenerColapsadoPanel() {
		panelColapsado=!panelColapsado;
	}


	public List<Agencia> getListaAgencia() {
		return listaAgencia;
	}


	public void setListaAgencia(List<Agencia> listaAgencia) {
		this.listaAgencia = listaAgencia;
	}


	public Agencia getAgencia() {
		return agencia;
	}


	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public Agencia getAgenciaSeleccionada() {
		return agenciaSeleccionada;
	}
	public void setAgenciaSeleccionada(Agencia agenciaSeleccionada) {
		this.agenciaSeleccionada = agenciaSeleccionada;
	}
}
