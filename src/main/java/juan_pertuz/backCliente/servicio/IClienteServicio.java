
package juan_pertuz.backCliente.servicio;

import java.util.List;
import juan_pertuz.backCliente.modelo.Cliente;

/**
 *
 * @author usuario
 */
public interface IClienteServicio {
    
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Integer id);
    
    public Cliente grabarCliente (Cliente cliente);
    
    public void delete(Integer id);
    
}

