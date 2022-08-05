package za.ac.cput.domain.passenger;

//219383448 KISSIMBA NYEMBO ISAAC

public class Passengers {
    private String PassengerID;
    private String PassengerFirstName;
    private String PassengerLastName;
    private String PassengerAge;

    private Passengers(Builder builder){
        this.PassengerID = builder.PassengerID;
        this.PassengerFirstName = builder.PassengerFirstName;
        this.PassengerLastName = builder.PassengerLastName;
        this.PassengerAge = builder.PassengerAge;
    }

    public String getPassengerID() {
        return PassengerID;
    }

    public void setID(String ID) {
        this.PassengerID = PassengerID;
    }

    public String getPassengerFirstName() {
        return PassengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        PassengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {
        return PassengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        PassengerLastName = passengerLastName;
    }

    public String getPassengerAge() {
        return PassengerAge;
    }

    public void setPassengerAge(String passengerAge) {
        PassengerAge = passengerAge;
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
    public static class Builder{
        private String PassengerID;
        private String PassengerFirstName;
        private String PassengerLastName;
        private String PassengerAge;

        public Builder setPassengerID(String PassengerID) {
            this.PassengerID = PassengerID;
            return this;
        }

        public Builder setPassengerFirstName(String passengerFirstName) {
            PassengerFirstName = passengerFirstName;
            return this;
        }

        public Builder setPassengerLastName(String passengerLastName) {
            PassengerLastName = passengerLastName;
            return this;
        }

        public Builder setPassengerAge(String passengerAge) {
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
