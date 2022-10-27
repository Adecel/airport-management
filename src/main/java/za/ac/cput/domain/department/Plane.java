package za.ac.cput.domain.department;
/*
  Kissimba Nyembo Isaac
  219383448
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
@Getter
@ToString
@Entity

public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String capacity;

    @NotNull
    private String model;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(getId(), plane.getId()) && Objects.equals(getName(), plane.getName()) && Objects.equals(getCapacity(), plane.getCapacity()) && Objects.equals(getModel(), plane.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCapacity(), getModel());
    }
}
