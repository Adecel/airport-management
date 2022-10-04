package za.ac.cput.domain.contact;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Setter
@Getter
@ToString
@Entity
public class Contact {
    @Id @NotNull
    private String id;
    @NotNull
    private String contact;
    @NotNull
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact1 = (Contact) o;
        return Objects.equals(getId(), contact1.getId()) && Objects.equals(getContact(), contact1.getContact()) && Objects.equals(getDescription(), contact1.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContact(), getDescription());
    }
}
