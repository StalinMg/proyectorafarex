package proyectorafatex.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyectorafatex.model.entities.Agencia;


/**
 * Session Bean implementation class managerAgencia
 */
@Stateless
@LocalBean
public class managerAgencia {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public managerAgencia() {
        // TODO Auto-generated constructor stub
    }
    public List<Agencia> findAllAgencia(){
    	String consulta="SELECT a FROM Agencia a";
    	Query q = em.createQuery(consulta, Agencia.class);
    	return q.getResultList();
    }
    
    public Agencia findAgencia(Number idagencia) {
    	return em.find(Agencia.class, idagencia);
    }
    
    public void actualizarAgencia(Agencia agencia) throws Exception{
    	Agencia a=findAgencia(agencia.getIdAgencia());
    	if(a==null)
    		throw new Exception("No existe el producto indicado");
    	a.setNombre(agencia.getNombre());
    	a.setTelefono(agencia.getTelefono());
    	em.merge(a);
    }
    
    public void insertarAgencia(Agencia agencia) throws Exception{
    	if(findAgencia(agencia.getIdAgencia())!=null)
    		throw new Exception("Esta agencia ya existe");
    	em.persist(agencia);
    }
    public void eliminarAgencia(Number idAgencia) {
    	Agencia a=findAgencia(idAgencia);
    	if(a!=null)
    		em.remove(a);
    }

}
