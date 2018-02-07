package walk.model.implementacoes;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import walk.model.entidades.Usuario;
import walk.model.interfaces.UsuarioDAO;

/**
 *
 * @author Jarvis
 */
public class UsuarioHibernate implements UsuarioDAO {
    private SessionFactory sessions;
    private static UsuarioHibernate instance;
    
    public static UsuarioHibernate getInstance(){
        if(instance == null){
            instance = new UsuarioHibernate();
        }
        return instance;
    }

    private UsuarioHibernate() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void adicionar(Usuario usuario) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.persist(usuario);
            t.commit();
        }catch(Exception addUsuarioError){
            System.out.println(addUsuarioError.getCause()
                    + "\nOcorreu um erro ao adicionar um usuário");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro"));
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Usuario recuperar(int codigo) {
        Session session = this.sessions.openSession();
        Usuario user = null;
        user = (Usuario) session.createQuery("From Usuario Where id_usuario=" + codigo).getResultList().get(0);
        session.close();
        
        return user;
    }

    @Override
    public void deletar(Usuario usuario) {   
       Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.delete(usuario);
            t.commit();
        }catch(Exception dellUsuarioError){
            System.out.println(dellUsuarioError.getCause()
                    + "\nOcorreu um erro ao deletar um usuário");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro"));
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void alterar(Usuario usuario) { 
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try{
            session.update(usuario);
            t.commit();
        }catch(Exception updateUsuarioError){
            System.out.println(updateUsuarioError.getCause()
                    + "\nOcorreu um erro ao alterar um usuário");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro"));
            t.rollback();
        }finally{
            session.close();
        }
    }
    @Override
    public List<Usuario> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Usuario> usuarios = null;
        usuarios = (List) session.createQuery("From Usuario").getResultList();
        session.close();
        return usuarios;
    }
    
    
}
