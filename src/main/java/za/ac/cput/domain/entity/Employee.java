package za.ac.cput.domain.entity;

public class Employee {
    private String employeeID;
    private String employeeName;
    private String depID;
    private String depName;

    //private construction
    private Employee() {

    }
    private Employee(Builder builder) {
        this.employeeID = builder.employeeID;
        this.employeeName = builder.employeeName;
        this.depID = builder.depID;
        this.depName = builder.depName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepID() {
        return depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", depID='" + depID + '\'' +
                ", depName='" + depName + '\'' +
                '}';
    }

    //Builder
    public static class Builder {
        private String employeeID;
        private String employeeName;
        private String depID;
        private String depName;

        //builder setters
        public Builder setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        public Builder setDepID(String depID) {
            this.depID = depID;
            return this;
        }

        public Builder setDepName(String depName) {
            this.depName = depName;
            return this;
        }

        public Builder copy(Employee employee) {
            this.employeeID = employee.employeeID;
            this.employeeName = employee.employeeName;
            this.depID = employee.depID;
            this.depName = employee.depName;

            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
