package Dao;

import Tables.Client;

import java.sql.SQLDataException;
import java.util.List;


public interface ClientDao {

    public void addClient(Client client) throws SQLDataException;
    public void deleteClient(Client client)throws SQLDataException;
    public Client getClient(int id)throws SQLDataException;
    public List<Client> getClients()throws SQLDataException;
}
