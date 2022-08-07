package za.ac.cput.domain.department;

//219383448 KISSIMBA NYEMBO ISAAC

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity

public class Luggage implements Serializable {
    @NotNull
    @Id
    private String luggageID;
    @NotNull private String luggageNumber;
    @NotNull private String luggageType;

    protected  Luggage(){}

    private  Luggage(Builder builder){
        this.luggageID = builder.luggageID;
        this.luggageNumber = builder.luggageNumber;
        this.luggageType = builder.luggageType;

    }

    public String getLuggageID() {
        return luggageID;
    }

    public String getLuggageNumber() {
        return luggageNumber;
    }

    public String getLuggageType() {
        return luggageType;
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "luggageID='" + luggageID + '\'' +
                ", luggageNumber='" + luggageNumber + '\'' +
                ", luggageType='" + luggageType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Luggage luggage = (Luggage) o;
        return Objects.equals(luggageID, luggage.luggageID) && Objects.equals(luggageNumber, luggage.luggageNumber) && Objects.equals(luggageType, luggage.luggageType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(luggageID, luggageNumber, luggageType);
    }

    public static class LuggageId{
        private String luggageID;
        private String luggageNumber;
        private String luggageType;

        public LuggageId(String luggageID, String luggageNumber, String luggageType) {
            this.luggageID = luggageID;
            this.luggageNumber = luggageNumber;
            this.luggageType = luggageType;
        }

        public String getLuggageID() {
            return luggageID;
        }

        public String getLuggageNumber() {
            return luggageNumber;
        }

        public String getLuggageType() {
            return luggageType;
        }
    }

    public static class Builder{
        private String luggageID;
        private String luggageNumber;
        private String luggageType;

        public Builder BuildLuggageID(String luggageID) {
            this.luggageID = luggageID;
            return this;
        }

        public Builder BuildLuggageNumber(String luggageNumber) {
            this.luggageNumber = luggageNumber;
            return this;
        }

        public Builder BuildLuggageType(String luggageType) {
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
