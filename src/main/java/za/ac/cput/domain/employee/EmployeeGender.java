/* EmployeeGender.java
 Entity for the EmployeeGender
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 2022/08/07
*/
package za.ac.cput.domain.employee;


import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class EmployeeGender
{
    private String employeeId;
    private String genId;

    private EmployeeGender(Builder builder)
    {
        this.employeeId = builder.employeeId;
        this.genId = builder.genId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getGenId() {
        return genId;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeGender employeeGender= (EmployeeGender) o;
        return employeeId.equals(employeeGender.employeeId) && genId.equals(employeeGender.genId);
    }

    public int hashCode(){
        return Objects.hash(employeeId,genId);
    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "employeeId='" + employeeId + '\'' +
                ", genId='" + genId + '\'' +
                '}';
    }

    public static class Builder
    {
        private String employeeId;
        private String genId;

        public Builder builderEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder builderGenId(String genId) {
            this.genId = genId;
            return this;
        }

        public EmployeeGender.Builder cody(EmployeeGender empGen)
        {
            this.employeeId=empGen.employeeId;
            this.genId=empGen.genId;

            return this;
        }

        public  EmployeeGender build() {
            return new EmployeeGender(this);
        }

    }
}
