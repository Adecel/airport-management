package za.ac.cput.domain.department;
/*
  Dieuci Djate Nsibu
  220169136
  */
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
public class FlightLine {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String description;

    @NotNull
    private String departure;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightLine)) return false;
        FlightLine that = (FlightLine) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getDeparture(), that.getDeparture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getDeparture());
    }
}
