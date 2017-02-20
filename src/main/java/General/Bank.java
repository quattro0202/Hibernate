package General;

import Dao.AccountDao;
import Dao.ClientDao;
import Dao.TransactionDao;
import Tables.Account;
import Tables.Client;
import Tables.Transaction;

import java.sql.SQLDataException;
import java.util.List;


public class Bank {

    public static void main(String[] args) throws SQLDataException {
        Factory factory = Factory.getFactory();
        ClientDao clientDao = factory.getClientDao();
        AccountDao accountDao = factory.getAccountDao();
        TransactionDao transactionDao = factory.getTransactionDao();

        Client client2 = clientDao.getClient(5);



        System.out.println(client2.getClientNumber() + " " + client2.getName() +
                " " + client2.getBirthDate());



        List<Client> clients = clientDao.getClients();
        System.out.println("Clients");
        for(Client client1:clients){
            System.out.println(client1.getClientNumber() + " " + client1.getName() +
                    " " + client1.getBirthDate());
        }

        List<Account> accounts = accountDao.getAccounts();
        System.out.println("Accounts");
        for (Account account :accounts) {
            System.out.println(account.getAccountNumber() +  " " + account.getClient().getName() + " " + account.getMoney() );
        }

        List<Transaction> transactions = transactionDao.getTransactions();
        System.out.println("Transactions");
        for (Transaction transaction :transactions) {
            System.out.println(transaction.getTransactionNumber() + " " + transaction.getAccountRecipient().getClient().getName()
                                + " " + transaction.getAccountSender().getClient().getName() + " " + transaction.getSendedMoney() + " " + transaction.getSendingDate()) ;
        }

    }
}
