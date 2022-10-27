package za.ac.cput.domain.user;
/*
  Name : Mahad Haasan
  student num: 219122822
  Capstone Project
 */
import lombok.*;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
@EqualsAndHashCode
public class Hostess {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Embedded
    private Name name;

    @Embedded
    private Gender gender;

    private String phoneNumber;

}
