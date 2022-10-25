package za.ac.cput.domain.contact;

import lombok.*;
import za.ac.cput.domain.user.User;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    //private Contact xontact;

    //do I have to write it like this or the way this primaryKey is written in class it coming from
//    @NotNull
//    private String contactTypeId; //(same question)do I have to write it like this or the way this primaryKey is written in class it coming from
//    @NotNull
//    private String contactId; // (same question) do I have to write it like this or the way this primaryKey is written in class it coming from
    @NotNull
    private String date;
    //here is string ok we have to use date as data type?
    @OneToOne(cascade = CascadeType.ALL)
    private ContactType contactType;
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserContact)) return false;
        UserContact that = (UserContact) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate());
    }
}
