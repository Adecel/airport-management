package za.ac.cput.domain.contact;
/*
  Hilary Cassidy Nguepi Nangmo
  220346887
*/
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
public class ContactType {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotNull
//    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
//    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @NotNull
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactType)) return false;
        ContactType that = (ContactType) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getPhoneNumber(), getDescription());
    }
}
