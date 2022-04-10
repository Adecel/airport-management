/* PassengerGender.java
 Entity for the PassengerGender
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.domain.entity;

public class PassengerGender
{
    private String passengerId;
    private String genId;

    public PassengerGender(PassengerGender.Builder builder)
    {
        this.passengerId =builder.passengerId;
        this.genId=builder.genId;

    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getGenId() {
        return genId;
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

        public PassengerGender.Builder setpassengerId(String passengerId) {
            this.passengerId =passengerId;
            return this;
        }

        public PassengerGender.Builder setgenId(String genId) {
            this.genId = genId;
            return this;
        }

        public PassengerGender.Builder cody(PassengerGender passGen)
        {
            this.passengerId=passGen.passengerId;
            this.genId=passGen.genId;
            return this;
        }
        public  PassengerGender Build()
        {
            return new PassengerGender(this);
        }

    }

}
