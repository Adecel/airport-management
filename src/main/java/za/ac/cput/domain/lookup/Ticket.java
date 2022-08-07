//DIEUCI DJATE NSIBU
//220169136

package za.ac.cput.domain.lookup;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Ticket implements Serializable {
    @Id
    @Column (name = "ticket_id")

    private String ticketID;
    private String destination;

    protected Ticket(){}

    private Ticket(Builder builder) {
        this.ticketID = builder.ticketID;
        this.destination = builder.destination;
    }
    public String getTicketID() {return ticketID;}
    public String getDestination() {return destination;}

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
            this.ticketID = ticket.ticketID;
            this.destination = ticket.destination;
            return this;
        }
        public Ticket build(){return new Ticket(this);}
    }
}


