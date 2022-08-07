package za.ac.cput.domain.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//        * aurthor : Mahad Hassan
//         *
//         * student number (219122822)
//         *
//         * Capstone Project
//         *
//         * EmployeeContact.java
//         * */
@Entity
@Table(name = "EmployeeContact")
public class EmployeeContact {
  @Id
  private String EmployeeId;
    private String ConId;

    protected EmployeeContact() {

    }

    // private cons
    private EmployeeContact(Builder builder){
        this.EmployeeId = builder.EmployeeId;
        this.ConId = builder.ConId;

    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public String getConId() {
        return ConId;
    } // getters

    @Override
    public String toString() {
        return "EmployeeContact{" +
                "EmployeeId='" + EmployeeId + '\'' +
                ", ConId='" + ConId + '\'' +
                '}';
    } // toString

    public static class Builder{
        private String EmployeeId;
        private String ConId;

        public Builder setEmployeeId(String employeeId) {
            EmployeeId = employeeId;

            return this;
        }

        public Builder setConId(String conId) {
            ConId = conId;
            return this;
        } // builder setters

        public Builder copy(EmployeeContact employeeContact){
            this.EmployeeId = employeeContact.EmployeeId;
            this.ConId = employeeContact.ConId;
            return this;
        } // copy method

        public EmployeeContact build(){

            return new EmployeeContact(this);
        }

    } // builder class
}
