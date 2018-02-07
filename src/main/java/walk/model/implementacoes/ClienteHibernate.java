package walk.model.implementacoes;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import walk.model.entidades.Cliente;
import walk.model.interfaces.ClienteDAO;

/**
 *
 * @author Jarvis
 */
public class ClienteHibernate implements ClienteDAO {

    private final SessionFactory sessions;
    private static ClienteHibernate instance = null;

    public static ClienteHibernate getInstance() {
        if (instance == null) {
            instance = new ClienteHibernate();
        }
        return instance;
    }

    private ClienteHibernate() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void adicionar(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(cliente);
            t.commit();
        } catch (Exception addClienteError) {
            System.out.println(addClienteError.getCause()
                    + "\nOcorreu um erro ao adiconar um Cliente");
            t.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public Cliente recuperar(int codigo) {
        Session session = this.sessions.openSession();
        
        try{
            return (Cliente) session.createQuery("From Cliente Where id_cliente="+codigo).getResultList().get(0);
        }catch(Exception recuperaClienteError){
            System.out.println(recuperaClienteError.getCause()
                        + "Ocorreu um erro ao recuperar um cliente");
        }finally{
            session.close();
        }
        
        return null;
    }

    @Override
    public void deletar(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(cliente);
            t.commit();
        } catch (Exception dellClienteError) {
            System.out.println(dellClienteError.getCause()
                    + "\nOcorreu um erro ao deletar um Cliente");
            t.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void alterar(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.update(cliente);
            t.commit();
        } catch (Exception updateClienteError) {
            System.out.println(updateClienteError.getCause()
                    + "\nOcorreu um erro ao alterar um Cliente");
            t.rollback();
        } finally {
            session.close();
        }
    }
        @Override
        public List<Cliente> recuperarTodos() {
            Session session = this.sessions.openSession();
            List<Cliente> clientes = null;
            
            clientes = session.createQuery("From Cliente").getResultList();
            
            session.close();
            
            return clientes;
        }

    }
