package za.ac.cput.domain.department;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
public class Ticket {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String userId; //(same question)do I have to write it like this or the way this primaryKey is written in class it coming from

    @NotNull
    private String flightLineId; //(same question)do I have to write it like this or the way this primaryKey is written in class it coming from

    @NotNull
    private String seatNumber;

    @NotNull
    private String price;

    @NotNull
    private String luggage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(getId(), ticket.getId()) && Objects.equals(getUserId(), ticket.getUserId()) && Objects.equals(getFlightLineId(), ticket.getFlightLineId()) && Objects.equals(getSeatNumber(), ticket.getSeatNumber()) && Objects.equals(getPrice(), ticket.getPrice()) && Objects.equals(getLuggage(), ticket.getLuggage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getFlightLineId(), getSeatNumber(), getPrice(), getLuggage());
    }
}
