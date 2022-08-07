/* Gender.java
 Entity for the Gender
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 2022/08/07
*/
package za.ac.cput.domain.lookup;

import org.springframework.data.annotation.Id;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Gender
{
    @Id @NotNull
    private String genId;
    @NotNull
    private String genName;

    private Gender() {
    }

    private Gender(Builder builder)
    {
        this.genId = builder.genId;
        this.genName = builder.genName;

    }

    public String getGenId() {
        return genId;
    }

    public String getGenName() {
        return genName;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender= (Gender) o;
        return genId.equals(gender.genId)&& genName.equals(gender.genName);
    }

    public int hashCode(){
        return Objects.hash(genId,genName);
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

        public Builder builderGenId(String genId) {
            this.genId = genId;
            return this;
        }

        public Builder builderGenName(String genName) {
            this.genName = genName;
            return this;
        }

        public Gender.Builder cody(Gender gender)
        {
            this.genId=gender.genId;
            this.genName=gender.genName;
            return this;
        }
        public  Gender build() {
            return new Gender(this);
        }

    }
}
