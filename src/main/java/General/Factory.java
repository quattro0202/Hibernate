package General;

import Dao.AccountDao;
import Dao.ClientDao;
import Dao.TransactionDao;
import DaoImpl.AccountDaoImpl;
import DaoImpl.ClientDaoImpl;
import DaoImpl.TransactionDaoImpl;

public class Factory {

    public static Factory factory;
    public static ClientDao clientDao;
    public static AccountDao accountDao;
    public static TransactionDao transactionDao;

    private Factory(){}

    public static Factory getFactory(){
        if (factory == null)
            factory = new Factory();
        return factory;
    }

    public ClientDao getClientDao(){
        if (clientDao == null)
            clientDao = new ClientDaoImpl();
        return clientDao;
    }

    public AccountDao getAccountDao(){
        if (accountDao == null)
            accountDao = new AccountDaoImpl();
        return accountDao;
    }

    public TransactionDao getTransactionDao(){
        if (transactionDao == null)
            transactionDao = new TransactionDaoImpl();
        return transactionDao;
    }

}