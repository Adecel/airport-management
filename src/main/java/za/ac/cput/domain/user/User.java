package za.ac.cput.domain.user;

import lombok.*;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;

import javax.persistence.Embedded;
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
public class User {

    @Id
    @NotNull
    private String id;

    @Embedded
    private Name name;

    @Embedded
    private Gender gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getGender(), user.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getGender());
    }
}
