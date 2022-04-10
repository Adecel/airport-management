package za.ac.cput.domain.entity;

//219383448 KISSIMBA NYEMBO ISAAC

public class RunWay {
    private String runwayNumber;
    private String FlightName;
    private String runwayStatus;


    private RunWay(RunWay.Builder builder){
        this.FlightName = builder.FlightName;
        this.runwayNumber = builder.runwayNumber;
        this.runwayStatus = builder.runwayStatus;

    }



    public String getRunwayNumber() {
        return runwayNumber;
    }

    public void setRunwayNumber(String runwayNumber) {
        this.runwayNumber = runwayNumber;
    }

    public String getFlightName() {
        return FlightName;
    }

    public void setFlightName(String flightName) {
        FlightName = flightName;
    }

    public String getRunwayStatus() {
        return runwayStatus;
    }

    public void setRunwayStatus(String runwayStatus) {
        this.runwayStatus = runwayStatus;
    }

    @Override
    public String toString() {
        return "RunWay{" +
                "runwayNumber='" + runwayNumber + '\'' +
                ", FlightName='" + FlightName + '\'' +
                ", runwayStatus='" + runwayStatus + '\'' +
                '}';
    }
    public static class Builder{
        private String runwayNumber;
        private String FlightName;
        private String runwayStatus;

        public Builder setRunwayNumber(String runwayNumber) {
            this.runwayNumber = runwayNumber;
            return this;
        }

        public Builder setFlightName(String flightName) {
            FlightName = flightName;
            return this;
        }

        public Builder setRunwayStatus(String runwayStatus) {
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

