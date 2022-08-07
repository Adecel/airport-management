/* PassengerGender.java
 Entity for the PassengerGender
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 2022/08/07
*/
package za.ac.cput.domain.passenger;

import za.ac.cput.domain.lookup.Gender;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class PassengerGender
{
    private String passengerId;
    private String genId;

    private PassengerGender(Builder builder)
    {
        this.passengerId = builder.passengerId;
        this.genId = builder.genId;

    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getGenId() {
        return genId;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerGender passengerGender= (PassengerGender) o;
        return passengerId.equals(passengerGender.passengerId)&& genId.equals(passengerGender.genId);
    }

    public int hashCode(){
        return Objects.hash(passengerId,genId);
    }

    @Override
    public String toString() {
        return "PassengerGender{" +
                "passengerId='" + passengerId + '\'' +
                ", genId='" + genId + '\'' +
                '}';
    }

    public static class Builder
    {
        private String passengerId;
        private String genId;

        public Builder builderPassengerId(String passengerId) {
            this.passengerId =passengerId;
            return this;
        }

        public Builder builderGenId(String genId) {
            this.genId = genId;
            return this;
        }

        public PassengerGender.Builder cody(PassengerGender passGen)
        {
            this.passengerId=passGen.passengerId;
            this.genId=passGen.genId;
            return this;
        }
        public  PassengerGender build()
        {
            return new PassengerGender(this);
        }

    }

}
