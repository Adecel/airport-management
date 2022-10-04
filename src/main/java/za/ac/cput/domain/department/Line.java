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
public class Line {

    @Id
    @NotNull
    private String flightLineId; //(same question)do I have to write it like this or the way this primaryKey is written in class it coming from

    @NotNull
    private String flightId; //(same question)do I have to write it like this or the way this primaryKey is written in class it coming from

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(getFlightLineId(), line.getFlightLineId()) && Objects.equals(getFlightId(), line.getFlightId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlightLineId(), getFlightId());
    }
}
