package za.ac.cput.domain.employee;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

// thinking about ValueObject (video: June assessment model, minute: "22:01 ")
// special functionality, refer to the resource on blackboard

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private String employeeID;
    private String employeeName;
    private String depName;
    //    @Column(nullable = false, updatable = false)
    private String depID;

    //private construction
    protected Employee() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getEmployeeID(), employee.getEmployeeID()) && Objects.equals(getEmployeeName(), employee.getEmployeeName()) && Objects.equals(getDepID(), employee.getDepID()) && Objects.equals(getDepName(), employee.getDepName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeID(), getEmployeeName(), getDepID(), getDepName());
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
        public Builder EmployeeID(String employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder EmployeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        public Builder DepID(String depID) {
            this.depID = depID;
            return this;
        }

        public Builder DepName(String depName) {
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
