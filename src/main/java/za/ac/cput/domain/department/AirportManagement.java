package za.ac.cput.domain.department;

/*
* Author : Adecel Rusty Mabiala
* Student Number : 219197229
* Capstone Project Deliverables
* */

import java.util.Objects;

public class AirportManagement {

    private final String airportName;
    private final String cityName;
    private final  String area;

    //private construction

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirportManagement)) return false;
        AirportManagement that = (AirportManagement) o;
        return Objects.equals(getAirportName(), that.getAirportName()) && Objects.equals(getCityName(), that.getCityName()) && Objects.equals(getArea(), that.getArea());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAirportName(), getCityName(), getArea());
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
        public Builder AirportName(String airportName) {
            this.airportName = airportName;
            return this;
        }

        public Builder CityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public Builder Area(String area) {
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
