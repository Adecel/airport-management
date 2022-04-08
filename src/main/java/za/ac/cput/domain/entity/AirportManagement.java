package za.ac.cput.domain.entity;

public class AirportManagement {
    private String airportName;
    private String cityName;
    private String area;

    //private construction
    private AirportManagement() {

    }
    private AirportManagement(Builder builder) {
        this.airportName = builder.airportName;
        this.cityName = builder.cityName;
        this.area = builder.area;
    }

    //getters
    public String getAirportName() {
        return airportName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getArea() {
        return area;
    }

    //setters
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setArea(String area) {
        this.area = area;
    }

    //methods of this entity
    public void open() {
        //
    }

    @Override
    public String toString() {
        return "AirportManagement{" +
                "airportName='" + airportName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    //Builder
    public static class Builder {
        private String airportName;
        private String cityName;
        private String area;

        //builder setters
        public Builder setAirportName(String airportName) {
            this.airportName = airportName;
            return this;
        }

        public Builder setCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public Builder setArea(String area) {
            this.area = area;
            return this;
        }

        public Builder copy(AirportManagement airportM) {
            this.airportName = airportM.airportName;
            this.cityName = airportM.cityName;
            this.area = airportM.area;

            return this;
        }

        public AirportManagement build() {
            return new AirportManagement(this);
        }
    }
}
