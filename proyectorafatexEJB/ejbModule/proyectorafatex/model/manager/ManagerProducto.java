package proyectorafatex.model.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import proyectorafatex.model.manager.ManagerDAO;
import proyectorafatex.model.entities.Agencia;
import proyectorafatex.model.entities.Producto;

/**
 * Session Bean implementation class ManagerProducto
 */
@Stateless
@LocalBean
public class ManagerProducto {

	@EJB
	private ManagerDAO managerDAO;
	private EntityManager em;
	
    public ManagerProducto() {
        // TODO Auto-generated constructor stub
    }
  	public int obtenerExistencia(Integer codigoProducto) throws Exception{
  		Producto p;
  		p=findProductoById(codigoProducto);
  		return p.getCantidadExistente().intValue();
  	}
 
  	@SuppressWarnings("unchecked")
  	public List<Producto> findAllProductos(){
  		return managerDAO.findAll(Producto.class, "o.nombre");
  	}
  	
 
  	public Producto findProductoById(Integer codigoProducto) throws Exception{
  		return (Producto) managerDAO.findById(Producto.class, codigoProducto);
  	}
  	
  
  	//public void insertarProducto(Producto p) throws Exception{
  	//	managerDAO.insertar(p);
  //	}
    public void insertarProducto(Producto producto) throws Exception{
    	if( findProductoById(producto.getIdProducto())!=null)
    		throw new Exception("Esta agencia ya existe");
    	em.persist(producto);
    }
 
  	public void eliminarProducto(Integer codigoProducto) throws Exception{
  		managerDAO.eliminar(Producto.class, codigoProducto);
  	}
 
  	public void actualizarProducto(Producto producto) throws Exception{
  		Producto p=null;
  		try {
  			//buscamos el producto a modificar desde la bdd:
  			p=findProductoById(producto.getIdProducto());
  			//actualizamos las propiedades:
  			p.setDescripcion(producto.getDescripcion());
  			p.setCantidadExistente(producto.getCantidadExistente());
  			p.setNombre(producto.getNombre());
  			p.setPrecioUnitario(producto.getPrecioUnitario());
  			p.setPrecioPorMayor(producto.getPrecioPorMayor());
  			p.setRutaImagen(producto.getRutaImagen());
  			p.setTamanio(producto.getTamanio());
  			p.setColor(producto.getColor());
  			p.setCantidadMinima(producto.getCantidadMinima());
  			p.setEmpleado(producto.getEmpleado());
  			//actualizamos:
  			managerDAO.actualizar(p);
  		} catch (Exception e) {
  			e.printStackTrace();
  			throw new Exception(e.getMessage());
  		}
  	}

}
