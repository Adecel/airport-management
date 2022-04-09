package za.ac.cput.domain.entity;

public class Department {
    private String depID;
    private String depName;
    private String description;

    //private construction
    private Department() {

    }
    private Department(Builder builder) {
        this.depID = builder.depID;
        this.depName = builder.depName;
        this.description = builder.description;
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

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setDescription(String description) {
        description = description;
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

        public Builder setDepID(String depID) {
            this.depID = depID;
            return this;
        }

        public Builder setDepName(String depName) {
            this.depName = depName;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Department.Builder copy(Department department) {
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
