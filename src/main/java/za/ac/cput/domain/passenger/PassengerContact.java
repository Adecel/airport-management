package za.ac.cput.domain.passenger;

/*
/Name : Mahad Haasan
Student Num: 219122822
Capstone Project
Class: PassengerContact.java
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PassengerContact")
public class PassengerContact {
  @Id
  private String passengerId;
    private String conId;

    protected PassengerContact() {

    }

    // private con
    private  PassengerContact(Builder builder){
        this.passengerId = builder.passengerId;
        this.conId = builder.conId;

    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getConId() {
        return conId;
    } // getters

    @Override
    public String toString() {
        return "PassengerContact{" +
                "passengerId='" + passengerId + '\'' +
                ", conId='" + conId + '\'' +
                '}';
    } // toString

    public static class Builder{
        private String passengerId;
        private String conId;

        public Builder setPassengerId(String passengerId) {
            this.passengerId = passengerId;
            return this;
        }

        public Builder setConId(String conId) {
            this.conId = conId;
            return this;

        } // builder setters

        public Builder copy(PassengerContact passengerContact){
            this.passengerId = passengerContact.passengerId;
            this.conId = passengerContact.conId;
            return this;

        } // copy method
        public PassengerContact build(){
            return  new PassengerContact(this);
        }
    }
}
