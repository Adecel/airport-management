package za.ac.cput.domain.entity;
//220169136 Dieuci Djate Nsibu
public class Flight {
    private String flightID;
    private String capacity;
    private String departureTime;
    private String arrivalTime;

    private Flight(){}

    private Flight(Builder builder) {
        this.flightID = builder.flightID;
        this.capacity = builder.capacity;
        this.departureTime = builder.departureTime;
        this.arrivalTime =builder. arrivalTime;
    }

    public void flightDetails(){};

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightID='" + flightID + '\'' +
                ", capacity='" + capacity + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }
    public static class Builder{
        private String flightID;
        private String capacity;
        private String departureTime;
        private String arrivalTime;

        public Builder setFlightID(String flightID) {
            this.flightID = flightID;
            return this;
        }

        public Builder setCapacity(String capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        public Builder setArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }
        public Builder copy(Flight flight){
            this.flightID=flight.flightID;
            this.capacity=flight.capacity;
            this.departureTime=flight.departureTime;
            this.arrivalTime=flight.arrivalTime;
            return this;
        }
        public Flight build(){
            return new Flight (this);
        }

    }
}
