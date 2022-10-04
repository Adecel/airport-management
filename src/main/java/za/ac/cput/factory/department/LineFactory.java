package za.ac.cput.factory.department;

import za.ac.cput.domain.department.Line;
import za.ac.cput.util.Helper;

public class LineFactory {

    public static Line build(String flightLineId, String flightId) {
        Helper.checkStringParam("flightLineId", flightLineId);
        Helper.checkStringParam("flightId", flightId);
        return Line.builder().flightLineId(flightLineId).flightId(flightId)
                .build();
    }
}
