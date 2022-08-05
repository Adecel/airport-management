package za.ac.cput.domain.lookup;

public class Contact {
    private String conId;
    private String conNumber;
    private String conDescription;


    // private cons
    private Contact(Builder builder){
        this.conId = builder.conId;
        this.conNumber = builder.conNumber;
        this.conDescription = builder.conDescription;

    }


    public String getConId() {
        return conId;
    }

    public String getConNumber() {
        return conNumber;
    }

    public String getConDescription() {
        return conDescription;
    } // getters

    public void setConId(String conId) {
        this.conId = conId;
    }

    public void setConNumber(String conNumber) {
        this.conNumber = conNumber;
    }

    public void setConDescription(String conDescription) {
        this.conDescription = conDescription;
    } // setters

    @Override
    public String toString() {
        return "Contact{" +
                "conId='" + conId + '\'' +
                ", conNumber='" + conNumber + '\'' +
                ", conDescription='" + conDescription + '\'' +
                '}';
    } // toString

    public static class Builder{
        private String conId;
        private String conNumber;
        private String conDescription;

        public Builder setConId(String conId) {
            this.conId = conId;
            return this;
        }

        public Builder setConNumber(String conNumber) {
            this.conNumber = conNumber;
            return this;

        }

        public Builder setConDescription(String conDescription) {
            this.conDescription = conDescription;
            return this;
        } // setters

        public Builder copy(Contact contact){
            this.conId = contact.conId;
            this.conNumber = contact.conNumber;
            this.conDescription = contact.conDescription;

            return this;
        } // copy method

        public Contact build(){

            return new Contact(this);
        }


    } // builder class
}
