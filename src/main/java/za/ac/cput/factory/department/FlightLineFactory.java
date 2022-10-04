package za.ac.cput.factory.department;

import za.ac.cput.domain.department.FlightLine;
import za.ac.cput.util.Helper;

public class FlightLineFactory {

    public static FlightLine build(String id, String description, String departure) {

        Helper.checkStringParam("FlightLineId", id);
        Helper.checkStringParam("description", description);
        Helper.checkStringParam("departure", departure);

        return FlightLine.builder().id(id).description(description)
                .departure(departure).build();
    }
}
