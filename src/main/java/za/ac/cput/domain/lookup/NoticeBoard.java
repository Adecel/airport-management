package za.ac.cput.domain.lookup;

//216266882 Mogamad Tawfeeq Cupido
//2022/08/07

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "NoticeBoard")
public class NoticeBoard {


    @NotNull @Id
    private String FlightID;
    @NotNull
    private String FlightName;
    @NotNull
    private String ArrivalTime;
    @NotNull
    private String DepartureTime;
    @NotNull
    private String Destination;


    public NoticeBoard() {
    }

    private NoticeBoard(Builder builder){
        this.FlightID = builder.FlightID;
        this.DepartureTime = builder.DepartureTime;
        this.ArrivalTime = builder.ArrivalTime;
        this.FlightName = builder.FlightName;
        this.Destination = builder.Destination;
    }

    public String getFlightID() {
        return FlightID;
    }

    public String getFlightName() {
        return FlightName;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoticeBoard noticeBoard= (NoticeBoard) o;

        return FlightID.equals(noticeBoard.getFlightID())&& FlightName.equals(noticeBoard.getFlightName());
    }



    public int hashCode(){
        return Objects.hash(FlightID,FlightName);
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    @Override
    public String toString() {
        return "NoticeBoard{" +
                "FlightID='" + FlightID + '\'' +
                ", FlightName='" + FlightName + '\'' +
                ", ArrivalTime='" + ArrivalTime + '\'' +
                ", DepartureTime='" + DepartureTime + '\'' +
                ", Destination='" + Destination + '\'' +
                '}';
    }
    public static class Builder{
        private String FlightID;
        private String FlightName;
        private String ArrivalTime;
        private String DepartureTime;
        private String Destination;

        public Builder setFlightID(String flightID) {
            FlightID = flightID;
            return this;
        }

        public Builder setFlightName(String flightName) {
            FlightName = flightName;
            return this;

        }

        public Builder setArrivalTime(String arrivalTime) {
            ArrivalTime = arrivalTime;
            return this;
        }

        public Builder setDepartureTime(String departureTime) {
            DepartureTime = departureTime;
            return this;
        }

        public Builder setDestination(String destination) {
            Destination = destination;
            return this;
        }
        public  Builder copy(NoticeBoard noticeBoard) {
            this.FlightID = noticeBoard.FlightID;
            this.FlightName = noticeBoard.FlightName;
            this.ArrivalTime = noticeBoard.ArrivalTime;
            this.DepartureTime = noticeBoard.DepartureTime;
            this.Destination = noticeBoard.Destination;
            return this;

        }
        public NoticeBoard build(){return new NoticeBoard(this);}
    }
}
