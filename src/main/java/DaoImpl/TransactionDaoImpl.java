package DaoImpl;

import Dao.TransactionDao;
import Tables.Transaction;
import Util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLDataException;
import java.util.List;


public class TransactionDaoImpl implements TransactionDao {
    @Override
    public void addTransaction(Transaction transaction) throws SQLDataException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(transaction);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }

    }

    @Override
    public void deleteTransaction(Transaction transaction) throws SQLDataException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(transaction);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }
    }

    @Override
    public Transaction getTransaction(int id) throws SQLDataException {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = (Transaction) session.get(Transaction.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }
        return transaction;
    }

    @Override
    public List<Transaction> getTransactions() throws SQLDataException {
        List<Transaction> transactions = null;

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transactions = session.createCriteria(Transaction.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()) )
                session.close();
        }

        return transactions;
    }
}
