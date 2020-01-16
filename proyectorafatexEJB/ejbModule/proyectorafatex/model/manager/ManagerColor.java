package proyectorafatex.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyectorafatex.model.entities.Color;

/**
 * Session Bean implementation class ManagerColor
 */
@Stateless
@LocalBean
public class ManagerColor {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerColor() {
        
    }
    
	public List<Color> findAllColor(){
    	String consulta="SELECT c FROM Color c";
    	Query q = em.createQuery(consulta, Color.class);
    	return q.getResultList();
    }
	
    public Color findColor(Number idColor) {
    	return em.find(Color.class, idColor);
    }
    public void actualizarColor(Color color) throws Exception{
    	Color c = findColor(color.getIdColor());
    	if(c==null)
    		throw new Exception("No existe el color indicado");
    	c.setNombre(color.getNombre());
    	em.merge(c);
    	
    }
    public void insertarColor(Color color) throws Exception{
    	if(findColor(color.getIdColor())!=null)
    		throw new Exception("Este color ya existe");
    	em.persist(color);
    		
    }
    public void eliminarColor(Number idColor) {
    	Color c=findColor(idColor);
    	if(c!=null)
    		em.remove(c);
    }

}
