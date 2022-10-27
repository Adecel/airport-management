package za.ac.cput.domain.lookup;
/*
  Kissimba Nyembo Isaac
  219383448
*/
import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
}
