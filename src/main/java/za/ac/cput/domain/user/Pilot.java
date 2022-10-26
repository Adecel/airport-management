package za.ac.cput.domain.user;
/*
  Mogamad Tawfeeq Cupido
  216266882
*/
import lombok.*;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@Entity
@EqualsAndHashCode
public class Pilot {
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
