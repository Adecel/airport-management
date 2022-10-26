package za.ac.cput.domain.user;
/*
  Name : Mahad Haasan
  student num: 219122822
  Capstone Project
 */
import lombok.*;
import za.ac.cput.domain.department.Flight;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
public class FlightPilot {
    @Id
    @NotNull
    private String id;

    @NotNull
    private String flightId; //(same question)do I have to write it like this or the way this primaryKey is written in class it coming from

    @NotNull
    private String userId;

    @NotNull
    private String date; //here is string ok we have to use date as data type? Answer: date is a complicated attribute, hence using the datatype String is fine

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightPilot)) return false;
        FlightPilot that = (FlightPilot) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFlightId(), that.getFlightId()) && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFlightId(), getUserId(), getDate());
    }
}
