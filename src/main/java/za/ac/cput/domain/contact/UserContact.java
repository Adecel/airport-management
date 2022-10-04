package za.ac.cput.domain.contact;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
//@Setter
@ToString
@Entity
public class UserContact {
    @Id
    @NotNull
    private String userId; //do I have to write it like this or the way this primaryKey is written in class it coming from
    @NotNull
    private String contactTypeId; //(same question)do I have to write it like this or the way this primaryKey is written in class it coming from
    @NotNull
    private String contactId; // (same question) do I have to write it like this or the way this primaryKey is written in class it coming from
    @NotNull
    private String date; //here is string ok we have to use date as data type?

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserContact)) return false;
        UserContact that = (UserContact) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getContactTypeId(), that.getContactTypeId()) && Objects.equals(getContactId(), that.getContactId()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getContactTypeId(), getContactId(), getDate());
    }
}
