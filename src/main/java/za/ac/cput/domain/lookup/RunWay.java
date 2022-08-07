package za.ac.cput.domain.lookup;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

//219383448 KISSIMBA NYEMBO ISAAC
@Entity
public class RunWay implements Serializable {
    @NotNull
    @Id
    private String runwayNumber;
    @NotNull private String FlightName;
    @NotNull private String runwayStatus;

    protected  RunWay(){}


    private RunWay(RunWay.Builder builder){
        this.FlightName = builder.FlightName;
        this.runwayNumber = builder.runwayNumber;
        this.runwayStatus = builder.runwayStatus;

    }



    public String getRunwayNumber() {
        return runwayNumber;
    }

    public String getFlightName() {
        return FlightName;
    }

    public String getRunwayStatus() {
        return runwayStatus;
    }

    @Override
    public String toString() {
        return "RunWay{" +
                "runwayNumber='" + runwayNumber + '\'' +
                ", FlightName='" + FlightName + '\'' +
                ", runwayStatus='" + runwayStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RunWay runWay = (RunWay) o;
        return Objects.equals(runwayNumber, runWay.runwayNumber) && Objects.equals(FlightName, runWay.FlightName) && Objects.equals(runwayStatus, runWay.runwayStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runwayNumber, FlightName, runwayStatus);
    }

    public static class RunWayID{
        private String runwayNumber;
        private String FlightName;
        private String runwayStatus;


        public RunWayID(String runwayNumber, String flightName, String runwayStatus) {
            this.runwayNumber = runwayNumber;
            FlightName = flightName;
            this.runwayStatus = runwayStatus;
        }

        public String getRunwayNumber() {
            return runwayNumber;
        }

        public String getFlightName() {
            return FlightName;
        }

        public String getRunwayStatus() {
            return runwayStatus;
        }
    }

    public static class Builder{
        private String runwayNumber;
        private String FlightName;
        private String runwayStatus;

        public Builder BuildRunwayNumber(String runwayNumber) {
            this.runwayNumber = runwayNumber;
            return this;
        }

        public Builder BuildFlightName(String flightName) {
            FlightName = flightName;
            return this;
        }

        public Builder BuildRunwayStatus(String runwayStatus) {
            this.runwayStatus = runwayStatus;
            return this;
        }
        public Builder copy(RunWay runWay){
            this.runwayNumber = runWay.runwayNumber;
            this.FlightName = runWay.FlightName;
            this.runwayStatus = runWay.runwayStatus;
            return this;

        }
        public RunWay build(){return new RunWay(this);}
    }
}


