package za.ac.cput.domain.department;

//216266882 Mogamad Tawfeeq Cupido
//2022/08/07

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Flight")
public class Flight {

    @NotNull @Id
    private String flightID;
    @NotNull
    private String capacity;
    @NotNull
    private String departureTime;
    @NotNull
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

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight= (Flight) o;

        return flightID.equals(flight.getFlightID());
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
