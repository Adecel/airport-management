package za.ac.cput.domain.entity;

public class PassengerContact {
    private String passengerId;
    private String conId;


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

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public void setConId(String conId) {
        this.conId = conId;
    } // setters

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
