package DaoImpl;

import Dao.AccountDao;
import Tables.Account;
import Util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLDataException;
import java.util.List;


public class AccountDaoImpl implements AccountDao {

    @Override
    public void addAccount(Account account) throws SQLDataException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }

    }

    @Override
    public void deleteAccount(Account account) throws SQLDataException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(account);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }
    }

    @Override
    public Account getAccount(int id) throws SQLDataException {
        Session session = null;
        Account account = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            account = (Account) session.get(Account.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }
        return account;
    }

    @Override
    public List<Account> getAccounts() throws SQLDataException {
        List<Account> accounts = null;

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            accounts = session.createCriteria(Account.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }

        return accounts;
    }
}
