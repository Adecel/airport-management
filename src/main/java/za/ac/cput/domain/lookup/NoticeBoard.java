package za.ac.cput.domain.lookup;

//219383448 KISSIMBA NYEMBO ISAAC

public class NoticeBoard {
    private String FlightID;
    private String FlightName;
    private String ArrivalTime;
    private String DepartureTime;
    private String Destination;

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

    public void setFlightID(String flightID) {
        FlightID = flightID;
    }

    public String getFlightName() {
        return FlightName;
    }

    public void setFlightName(String flightName) {
        FlightName = flightName;
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
