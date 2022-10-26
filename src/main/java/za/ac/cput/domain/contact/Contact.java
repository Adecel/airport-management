package za.ac.cput.domain.contact;
/*
  Hilary Cassidy Nguepi Nangmo
  220346887
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
@Setter
@Getter
@ToString
@Entity
public class Contact {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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
