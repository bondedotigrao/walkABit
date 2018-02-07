package walk.view;

import walk.model.entidades.Cliente;
import walk.model.entidades.Usuario;
import walk.model.implementacoes.ClienteHibernate;
import walk.model.implementacoes.UsuarioHibernate;

/**
 *
 * @author Jarvis
 */
public class teste {

    public static void main(String args[]) {
       ClienteHibernate cn = ClienteHibernate.getInstance();
        
        cn.adicionar(new Cliente("imperio","email123",null));
        
        UsuarioHibernate uh = UsuarioHibernate.getInstance();
        
        uh.adicionar(new Usuario("nome","numero","email"));
  
    }
}
