/* Gender.java
 Entity for the Gender
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.domain.entity;

public class Gender
{
    private String genId;
    private String genName;

    public Gender(Builder builder)
    {
        this.genId=builder.genId;
        this.genName=builder.genName;

    }

    public String getGenId() {
        return genId;
    }

    public String getGenName() {
        return genName;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genId='" + genId + '\'' +
                ", genName='" + genName + '\'' +
                '}';
    }

    public static class Builder
    {
        private String genId;
        private String genName;

        public Builder setgenId(String genId) {
            this.genId =genId;
            return this;
        }

        public Builder setgenName(String genName) {
            this.genName = genName;
            return this;
        }

        public Builder cody(Gender gender)
        {
            this.genId=gender.genId;
            this.genName=gender.genName;
            return this;
        }
        public  Gender Build()
        {
            return new Gender(this);
        }

    }
}
