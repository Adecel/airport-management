package za.ac.cput.domain.passenger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

//219383448 KISSIMBA NYEMBO ISAAC
@Entity
public class Passengers implements Serializable {

    @NotNull
    @Id
    private String PassengerID;
    @NotNull private String PassengerFirstName;
    @NotNull private String PassengerLastName;
    @NotNull private String PassengerAge;

    protected Passengers(){}

    private Passengers(Builder builder){
        this.PassengerID = builder.PassengerID;
        this.PassengerFirstName = builder.PassengerFirstName;
        this.PassengerLastName = builder.PassengerLastName;
        this.PassengerAge = builder.PassengerAge;
    }

    public String getPassengerID() {
        return PassengerID;
    }
    public String getPassengerFirstName() {
        return PassengerFirstName;
    }
    public String getPassengerLastName() {
        return PassengerLastName;
    }
    public String getPassengerAge() {
        return PassengerAge;
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "ID='" + PassengerID + '\'' +
                ", PassengerFirstName='" + PassengerFirstName + '\'' +
                ", PassengerLastName='" + PassengerLastName + '\'' +
                ", PassengerAge='" + PassengerAge + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passengers that = (Passengers) o;
        return Objects.equals(PassengerID, that.PassengerID) && Objects.equals(PassengerFirstName, that.PassengerFirstName) && Objects.equals(PassengerLastName, that.PassengerLastName) && Objects.equals(PassengerAge, that.PassengerAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PassengerID, PassengerFirstName, PassengerLastName, PassengerAge);
    }
    public static class PassengerID{
        private String PassengerID;
        private String PassengerFirstName;
        private String PassengerLastName;
        private String PassengerAge;

        public PassengerID(String passengerID, String passengerFirstName, String passengerLastName, String passengerAge) {
            PassengerID = passengerID;
            PassengerFirstName = passengerFirstName;
            PassengerLastName = passengerLastName;
            PassengerAge = passengerAge;
        }

        public String getPassengerID() {
            return PassengerID;
        }

        public String getPassengerFirstName() {
            return PassengerFirstName;
        }

        public String getPassengerLastName() {
            return PassengerLastName;
        }

        public String getPassengerAge() {
            return PassengerAge;
        }
    }


    public static class Builder{
        private String PassengerID;
        private String PassengerFirstName;
        private String PassengerLastName;
        private String PassengerAge;

        public Builder BuildPassengerID(String PassengerID) {
            this.PassengerID = PassengerID;
            return this;
        }

        public Builder BuildPassengerFirstName(String passengerFirstName) {
            PassengerFirstName = passengerFirstName;
            return this;
        }

        public Builder BuildPassengerLastName(String passengerLastName) {
            PassengerLastName = passengerLastName;
            return this;
        }

        public Builder BuildPassengerAge(String passengerAge) {
            PassengerAge = passengerAge;
            return this;
        }
        public Builder copy(Passengers passengers) {
            this.PassengerID = passengers.PassengerID;
            this.PassengerAge = passengers.PassengerAge;
            this.PassengerFirstName = passengers.PassengerFirstName;
            this.PassengerLastName = passengers.PassengerLastName;
            return this;
        }
        public Passengers build(){return new Passengers(this);}
    }
}
