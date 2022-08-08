package za.ac.cput.domain.department;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Department {
    @Id @NotNull
    private String depID;
    @NotNull
    private String depName;
    @NotNull
    private String description;

    private Department(Builder builder) {
        this.depID = builder.depID;
        this.depName = builder.depName;
        this.description = builder.description;
    }

    public Department() {

    }

    public String getDepID() {
        return depID;
    }

    public String getDepName() {
        return depName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(getDepID(), that.getDepID()) && Objects.equals(getDepName(), that.getDepName()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepID(), getDepName(), getDescription());
    }

    @Override
    public String toString() {
        return "Department{" +
                "depID='" + depID + '\'' +
                ", depName='" + depName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    //Builder
    public static class Builder {
        private String depID;
        private String depName;
        private String description;

        //builder setters

        public Builder DepID(String depID) {
            this.depID = depID;
            return this;
        }

        public Builder DepName(String depName) {
            this.depName = depName;
            return this;
        }

        public Builder Description(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Department department) {
            this.depID = department.depID;
            this.depName = department.depName;
            this.description = department.description;

            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}
