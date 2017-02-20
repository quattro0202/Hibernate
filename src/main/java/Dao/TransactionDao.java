package Dao;

import Tables.Transaction;

import java.sql.SQLDataException;
import java.util.List;


public interface TransactionDao {
    public void addTransaction(Transaction transaction) throws SQLDataException;
    public void deleteTransaction(Transaction transaction)throws SQLDataException;
    public Transaction getTransaction(int id)throws SQLDataException;
    public List<Transaction> getTransactions()throws SQLDataException;

}
