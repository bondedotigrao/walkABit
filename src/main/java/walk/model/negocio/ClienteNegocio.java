package walk.model.negocio;

import java.util.List;
import walk.model.entidades.Cliente;
import walk.model.implementacoes.ClienteHibernate;
import walk.model.interfaces.DAO;

/**
 *
 * @author Jarvis
 */
public class ClienteNegocio {

    private final DAO<Cliente> dao;

    public ClienteNegocio() {
        this.dao = ClienteHibernate.getInstance();
    }

    public void adicionar(Cliente cliente) {
        if (((ClienteHibernate) dao).recuperar(cliente.getCodigo()) == null) {
            dao.adicionar(cliente);
        }

    }
    
    public Cliente recuperar(Integer codigo){
        if(codigo != null){
            return ((ClienteHibernate)dao).recuperar(codigo);
        }
        return null;
    }
    
    public void alterar(Cliente cliente){
        if(((ClienteHibernate)dao).recuperar(cliente.getCodigo()) != null){
            ((ClienteHibernate)dao).alterar(cliente);
        }
    }
    
    public void deletar(Cliente cliente){
        if(((ClienteHibernate)dao).recuperar(cliente.getCodigo()) != null){
            ((ClienteHibernate)dao).deletar(cliente);
        }
    }
    
    public List<Cliente> recuperarTodos(){
        return  ((ClienteHibernate)dao).recuperarTodos();
    }
}
