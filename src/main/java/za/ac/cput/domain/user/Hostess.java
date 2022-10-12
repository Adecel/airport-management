package za.ac.cput.domain.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
public class Hostess {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String flightId;

    @NotNull
    private String userId;

    @NotNull
    private String date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hostess)) return false;
        Hostess hostess = (Hostess) o;
        return Objects.equals(getId(), hostess.getId()) && Objects.equals(getFlightId(), hostess.getFlightId()) && Objects.equals(getUserId(), hostess.getUserId()) && Objects.equals(getDate(), hostess.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFlightId(), getUserId(), getDate());
    }
}
