package za.ac.cput.domain.user;

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
public class Hostess {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String flightId; //(same question)do I have to write it like this or the way this primaryKey is written in class it coming from

    @NotNull
    private String userId; //do I have to write it like this or the way this primaryKey is written in class it coming from

    @NotNull
    private String date; //here is string ok we have to use date as data type?

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
