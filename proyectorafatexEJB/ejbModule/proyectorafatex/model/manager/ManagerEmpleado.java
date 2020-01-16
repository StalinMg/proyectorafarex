package proyectorafatex.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyectorafatex.model.entities.Empleado;

/**
 * Session Bean implementation class ManagerEmpleado
 */
@Stateless
@LocalBean
public class ManagerEmpleado {
	@PersistenceContext
	private EntityManager em;	
    /**	
     * Default constructor. 
     */
    public ManagerEmpleado() {
        
    }
    public List<Empleado> findAllEmpleados(){
    	String consulta="SELECT e FROM Empleado e";
    	Query q=em.createQuery(consulta,Empleado.class);
    	return q.getResultList();
    }
    public Empleado findEmpleado(Number idempleado) {
    	return em.find(Empleado.class,idempleado);
    }
    public void actualizarEmpleado(Empleado empleado) throws Exception{
    	Empleado e = findEmpleado(empleado.getIdEmpleado());
    	if(e==null)
    		throw new Exception("No existe el Empleado Indicado");
    	e.setCedula(empleado.getCedula());
    	e.setNombre(empleado.getNombre());
    	e.setApellido(empleado.getApellido());
    	e.setCorreo(empleado.getCorreo());
    	e.setDireccion(empleado.getDireccion());
    	e.setTelefono(empleado.getTelefono());
    	e.setCelular(empleado.getCelular());
    	em.merge(e);
    	
    }
    public void insertarEmpleado(Empleado empleado) throws Exception{
    	if(findEmpleado(empleado.getIdEmpleado())!=null)
    		throw new Exception("Este Empleado ya existe");
    		em.persist(empleado);
    }
    public void eliminarEmpleado(Number idEmpleado) {
    	Empleado e = findEmpleado(idEmpleado);
    	if(e!=null)
    		em.remove(e);
    }

}
