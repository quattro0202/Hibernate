package Tables;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "transactions")
public class Transaction {


    private int transactionNumber;
    private Account accountRecipient;
    private Account accountSender;
    private double sendedMoney;
    private Date sendingDate;

    public Transaction(){}

    @Id
    @Column(name = "transactionNumber")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    @JoinColumn(name = "accountRecipient", referencedColumnName = "accountNumber")
    public Account getAccountRecipient() {
        return accountRecipient;
    }

    public void setAccountRecipient(Account accountRecipient) {
        this.accountRecipient = accountRecipient;
    }

    @JoinColumn(name = "accountSender", referencedColumnName = "accoutNumber")
    public Account getAccountSender() {
        return accountSender;
    }

    public void setAccountSender(Account accountSender) {
        this.accountSender = accountSender;
    }

    @Column(name = "sendedMoney")
    public double getSendedMoney() {
        return sendedMoney;
    }

    public void setSendedMoney(double sendedMoney) {
        this.sendedMoney = sendedMoney;
    }

    @Column(name = "sendingDate")
    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }
}
