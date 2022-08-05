package za.ac.cput.domain.employee;

//        * aurthor : Mahad Hassan
//         *
//         * student number (219122822)
//         *
//         * Date 8 april 2022
//         *
//         * EmployeeContact.java
//         * */

public class EmployeeContact {
    private String EmployeeId;
    private String ConId;


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

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public void setConId(String conId) {
        ConId = conId;
    } // setters

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
