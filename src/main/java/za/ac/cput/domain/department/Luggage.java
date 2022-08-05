package za.ac.cput.domain.department;

//219383448 KISSIMBA NYEMBO ISAAC

public class Luggage {
    private String luggageID;
    private String luggageNumber;
    private String luggageType;

    private  Luggage(Builder builder){
        this.luggageID = builder.luggageID;
        this.luggageNumber = builder.luggageNumber;
        this.luggageType = builder.luggageType;

    }

    public String getLuggageID() {
        return luggageID;
    }

    public void setLuggageID(String luggageID) {
        this.luggageID = luggageID;
    }

    public String getLuggageNumber() {
        return luggageNumber;
    }

    public void setLuggageNumber(String luggageNumber) {
        this.luggageNumber = luggageNumber;
    }

    public String getLuggageType() {
        return luggageType;
    }

    public void setLuggageType(String luggageType) {
        this.luggageType = luggageType;
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "luggageID='" + luggageID + '\'' +
                ", luggageNumber='" + luggageNumber + '\'' +
                ", luggageType='" + luggageType + '\'' +
                '}';
    }
    public static class Builder{
        private String luggageID;
        private String luggageNumber;
        private String luggageType;

        public Builder setLuggageID(String luggageID) {
            this.luggageID = luggageID;
            return this;
        }

        public Builder setLuggageNumber(String luggageNumber) {
            this.luggageNumber = luggageNumber;
            return this;
        }

        public Builder setLuggageType(String luggageType) {
            this.luggageType = luggageType;
            return this;
        }
        public Builder copy(Luggage luggage){
            this.luggageID = luggage.luggageID;
            this.luggageNumber = luggage.luggageNumber;
            this.luggageType = luggage.luggageType;
            return this;

        }
        public Luggage build(){return  new Luggage(this);}
    }
}
