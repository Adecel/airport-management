package za.ac.cput.domain.passenger;
//Dieuci Djate Nsibu 220169136

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import java.io.Serializable;


public class PassengerTicket implements Serializable {
    @JoinColumn(name = "passenger_id",referencedColumnName = "passenger_id")
    private String passengerID;
    @JoinColumn(name = "ticket_id",referencedColumnName = "ticket_id")
    private String ticketID;
    private int price;
    @JoinColumn(name = "luggage_id",referencedColumnName = "luggage_id")
    private String luggageID;

    protected PassengerTicket(){}

    private PassengerTicket(Builder builder) {
        this.passengerID = builder.passengerID;
        this.ticketID = builder.ticketID;
        this.price = builder.price;
        this.luggageID = builder.luggageID;
    }
    public String getPassengerID() {return passengerID;}
    public String getTicketID() {return ticketID;}
    public int getPrice() {return price;}
    public String getLuggageID() {return luggageID;}

    @Override
    public String toString() {
        return "PassengerTicketService{" +
                "passengerID='" + passengerID + '\'' +
                ", ticketID='" + ticketID + '\'' +
                ", price=" + price +
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
            this.ticketID = passengerTicket.ticketID;
            this.price = passengerTicket.price;
            this.luggageID = passengerTicket.luggageID;
            return this;
        }
        public PassengerTicket build(){return new PassengerTicket(this);}
    }

}
