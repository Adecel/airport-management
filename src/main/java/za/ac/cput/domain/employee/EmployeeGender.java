/* EmployeeGender.java
 Entity for the EmployeeGender
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.domain.employee;

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

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setGenId(String genId) {
        this.genId = genId;
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

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setGenId(String genId) {
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
