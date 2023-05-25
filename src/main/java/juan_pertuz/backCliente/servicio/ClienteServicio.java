/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juan_pertuz.backCliente.servicio;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import juan_pertuz.backCliente.modelo.Cliente;
import juan_pertuz.backCliente.repositorio.ClienteRepositorio;


/**
 *
 * @author Juan Pertuz
 */
@Service
@Transactional
public  class ClienteServicio implements IClienteServicio{
    
    @Autowired
    private ClienteRepositorio clienterepo;
        
        public List<Cliente>  getCliente(){
                return clienterepo.findAll();               
        }
     
        @Override
        public Cliente grabarCliente(Cliente cliente){
            return clienterepo.save(cliente);
        }
        
        @Override
        public void delete(Integer id){
            clienterepo.deleteById(id);
        }

    @Override
    public List<Cliente> getClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente getCliente(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
