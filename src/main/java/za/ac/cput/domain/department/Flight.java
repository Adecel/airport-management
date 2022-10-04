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
public class Flight {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String departureDateAndTime;

    @NotNull
    private String arrivalDateAndTime;

    @NotNull
    private String planeId; //(same question)do I have to write it like this or the way this primaryKey is written in class it coming from

    @NotNull
    private String description;

    @NotNull
    private String departureLocation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(getId(), flight.getId()) && Objects.equals(getDepartureDateAndTime(), flight.getDepartureDateAndTime()) && Objects.equals(getArrivalDateAndTime(), flight.getArrivalDateAndTime()) && Objects.equals(getPlaneId(), flight.getPlaneId()) && Objects.equals(getDescription(), flight.getDescription()) && Objects.equals(getDepartureLocation(), flight.getDepartureLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDepartureDateAndTime(), getArrivalDateAndTime(), getPlaneId(), getDescription(), getDepartureLocation());
    }
}
