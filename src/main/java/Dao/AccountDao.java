package Dao;

import Tables.Account;

import java.sql.SQLDataException;
import java.util.List;


public interface AccountDao {
    public void addAccount(Account account) throws SQLDataException;
    public void deleteAccount(Account account)throws SQLDataException;
    public Account getAccount(int id)throws SQLDataException;
    public List<Account> getAccounts()throws SQLDataException;
}
