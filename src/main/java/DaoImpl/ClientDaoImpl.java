package DaoImpl;

import Dao.ClientDao;
import Tables.Client;
import Util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLDataException;
import java.util.List;


public class ClientDaoImpl implements ClientDao{

    @Override
    public void addClient(Client client) throws SQLDataException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }
    }

    @Override
    public void deleteClient(Client client) throws SQLDataException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }

    }

    @Override
    public Client getClient(int id) throws SQLDataException {
        Session session = null;
        Client client = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            client = (Client) session.get(Client.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }
        return client;
    }

    @Override
    public List<Client> getClients() throws SQLDataException {
        List<Client> clients = null;

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            clients = session.createCriteria(Client.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }

        return clients;
    }
}
