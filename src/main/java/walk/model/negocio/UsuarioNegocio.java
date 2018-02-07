package walk.model.negocio;

import java.util.List;
import walk.model.entidades.Usuario;
import walk.model.implementacoes.UsuarioHibernate;
import walk.model.interfaces.DAO;

/**
 *
 * @author Jarvis
 */
public class UsuarioNegocio {
    private final DAO<Usuario> dao;

    public UsuarioNegocio() {
        this.dao = UsuarioHibernate.getInstance();
    }
    
    public void adicionar(Usuario usuario){
        if(((UsuarioHibernate)dao).recuperar(usuario.getCodigo()) == null){
            this.dao.adicionar(usuario);
        }
    }
    
    public Usuario recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        return ((UsuarioHibernate)dao).recuperar(codigo);
    }
    
    public void deletar(Usuario usuario){
        if(((UsuarioHibernate)dao).recuperar(usuario.getCodigo()) != null){
            this.dao.deletar(usuario);
        }
    }
    
    public void alterar(Usuario usuario){
        if(((UsuarioHibernate)dao).recuperar(usuario.getCodigo()) != null){
            this.dao.alterar(usuario);
        }
    }
    
    public List<Usuario> recuperarTodos(){
        return ((UsuarioHibernate)dao).recuperarTodos();
    }
}
