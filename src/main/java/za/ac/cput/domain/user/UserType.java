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
public class UserType {
    @Id
    @NotNull
    private String userId; //(same question)do I have to write it like this or the way this primaryKey is written in class it coming from

    @NotNull
    private String userCategoryId; //(same question)do I have to write it like this or the way this primaryKey is written in class it coming from

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserType)) return false;
        UserType userType = (UserType) o;
        return Objects.equals(getUserId(), userType.getUserId()) && Objects.equals(getUserCategoryId(), userType.getUserCategoryId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserCategoryId());
    }
}
