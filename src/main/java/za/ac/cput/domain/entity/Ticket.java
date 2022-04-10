package za.ac.cput.domain.entity;

public class Ticket {
    private String ticketID;
    private String destination;

    private Ticket(){}

    private Ticket(Builder builder) {
        this.ticketID=builder.ticketID;
        this.destination=builder.destination;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID='" + ticketID + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
    public static class Builder{
        private String ticketID;
        private String destination;

        public Builder setTicketID(String ticketID) {
            this.ticketID = ticketID;
            return this;
        }

        public Builder setDestination(String destination) {
            this.destination = destination;
            return this;
        }
        public Builder copy(Ticket ticket){
            this.ticketID=ticket.ticketID;
            this.destination=ticket.destination;
            return this;
        }
        public Ticket build(){
            return new Ticket(this);
        }
    }
}
