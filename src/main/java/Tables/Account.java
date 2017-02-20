package Tables;

import javax.persistence.*;


@Entity
@Table(name = "accounts")
public class Account {

    private int accountNumber;
    private Client client;
    private double money;

    public Account(){}

    @Id
    @Column(name = "accountNumber")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @JoinColumn(name = "clientNum", referencedColumnName = "clientNumber")
    public Client getClient() {
        return client;
    }

    public void setClient (Client client) {
        this.client = client;
    }

    @Column(name = "money")
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
