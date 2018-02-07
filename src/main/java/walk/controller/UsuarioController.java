package walk.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import walk.model.entidades.Usuario;
import walk.model.negocio.UsuarioNegocio;

/**
 *
 * @author Jarvis
 */
public class UsuarioController {
    private final UsuarioNegocio usuarioNegocio;
    private Usuario cadUsuario;

    public UsuarioController() {
        this.usuarioNegocio = new UsuarioNegocio();
        this.cadUsuario = new Usuario();
    }
    
    public void adicionar(){
        this.usuarioNegocio.adicionar(cadUsuario);
        this.cadUsuario = new Usuario();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucesso!"));
    }

    public Usuario getCadUsuario() {
        return cadUsuario;
    }

    public void setCadUsuario(Usuario cadUsuario) {
        this.cadUsuario = cadUsuario;
    }
    
    
}
