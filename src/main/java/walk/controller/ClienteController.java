package walk.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import walk.model.entidades.Cliente;
import walk.model.negocio.ClienteNegocio;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@RequestScoped
public class ClienteController {
    private final ClienteNegocio clienteNegocio;
    private Cliente cadCliente;

    public ClienteController() {
        this.clienteNegocio = new ClienteNegocio();
        this.cadCliente = new Cliente();
    }
    
    public void adicionar(){
        this.clienteNegocio.adicionar(cadCliente);
        this.cadCliente = new Cliente();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucesso!"));
    }

    public Cliente getCadCliente() {
        return cadCliente;
    }

    public void setCadCliente(Cliente cadCliente) {
        this.cadCliente = cadCliente;
    }
    
    
}
