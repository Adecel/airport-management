package za.ac.cput.domain.lookup;
/*
  Dieuci Djate Nsibu
  220169136
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
public class Gender {
    private String gender;
    private String description;
}
