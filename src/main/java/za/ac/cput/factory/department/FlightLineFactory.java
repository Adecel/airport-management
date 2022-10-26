package za.ac.cput.factory.department;
/*
  Dieuci Djate Nsibu
  220169136
  */
import za.ac.cput.domain.department.FlightLine;
import za.ac.cput.util.Helper;

public class FlightLineFactory {

    public static FlightLine build(int id, String description, String departure) {


        Helper.checkStringParam("description", description);
        Helper.checkStringParam("departure", departure);

        return FlightLine.builder().id(id).description(description)
                .departure(departure).build();
    }
}
