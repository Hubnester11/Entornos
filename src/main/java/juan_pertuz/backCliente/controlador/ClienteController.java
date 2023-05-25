/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juan_pertuz.backCliente.controlador;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static javax.net.ssl.SSLEngineResult.Status.OK;
import juan_pertuz.backCliente.modelo.Cliente;
import juan_pertuz.backCliente.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteServicio clienteService;
    
    @GetMapping("/list")
    public List<Cliente> consultarTodo() {
        return (clienteService.getCliente());
    }
    
    @GetMapping("/list/{id}")
    public Cliente buscarPorId(@PathVariable Integer id){   
            return clienteService.getCliente(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Cliente> agregar(@RequestBody Cliente cliente){   
            Cliente obj = clienteService.grabarCliente(cliente);
            return new ResponseEntity<>(obj, HttpStatus.OK);      
    }
    
    /**
     *
     * @param cliente
     * @return
     */
    @PutMapping("/")
    public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente) {      
       Cliente obj = clienteService.getCliente(cliente.getIdcliente());
       if(obj != null){
            obj.setDireccion(cliente.getDireccion());
            obj.setApellidos(cliente.getApellidos());
            obj.setDocumento(cliente.getDocumento());
            obj.setEmail(cliente.getEmail());
            obj.setNombres(cliente.getNombres());
            obj.setTipdoc(cliente.getTipdoc());
            clienteService.grabarCliente(obj);
       }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
       }
            return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> eliminar(@PathVariable Integer id){
        Cliente obj = clienteService.getCliente(id);
        if(obj != null){
            clienteService.delete(id);
        }else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
       }
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }
}

