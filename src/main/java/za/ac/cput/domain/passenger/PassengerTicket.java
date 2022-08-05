package za.ac.cput.domain.passenger;
//Dieuci Djate Nsibu 220169136
public class PassengerTicket {
    private String passengerID;
    private String ticketID;
    private int price;
    private String luggageID;

    private PassengerTicket(){}

    private PassengerTicket(Builder builder) {
        this.passengerID = builder.passengerID;
        this.ticketID = builder.ticketID;
        this.price = builder.price;
        this.luggageID = builder.luggageID;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLuggageID() {
        return luggageID;
    }

    public void setLuggageID(String luggageID) {
        this.luggageID = luggageID;
    }

    @Override
    public String toString() {
        return "PassengerTicket{" +
                "passengerID='" + passengerID + '\'' +
                ", ticketID='" + ticketID + '\'' +
                ", price=" +"R"+ price +
                ", luggageID='" + luggageID + '\'' +
                '}';
    }
    public static class Builder{
        private String passengerID;
        private String ticketID;
        private int price;
        private String luggageID;

        public Builder setPassengerID(String passengerID) {
            this.passengerID = passengerID;
            return this;
        }

        public Builder setTicketID(String ticketID) {
            this.ticketID = ticketID;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setLuggageID(String luggageID) {
            this.luggageID = luggageID;
            return this;
        }
        public Builder copy(PassengerTicket passengerTicket){
            this.passengerID = passengerTicket.passengerID;
            this.ticketID =passengerTicket.ticketID;
            this.price = passengerTicket.price;
            this.luggageID = passengerTicket.luggageID;
            return this;
        }
        public PassengerTicket build(){
            return new PassengerTicket(this);
        }

    }
}
