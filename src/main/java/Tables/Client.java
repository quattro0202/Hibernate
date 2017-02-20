package Tables;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "clients")
public class Client {

    private int clientNumber;
    private String name;
    private Date birthDate;

    public Client(){}

    @Id
    @Column(name = "clientNumber")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "birthDate")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
