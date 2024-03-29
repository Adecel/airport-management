package za.ac.cput.factory.department;
/*
  Kissimba Nyembo Isaac
  219383448
*/

import za.ac.cput.domain.department.Plane;
import za.ac.cput.util.Helper;

public class PlaneFactory {

    public static Plane build(int id, String name, String capacity,
                              String model) {

       // Helper.checkStringParam("PlaneId", id);
        Helper.checkStringParam("name", name);
        Helper.checkStringParam("capacity", capacity);
        Helper.checkStringParam("model", model);

        return Plane.builder().id(id).name(name).capacity(capacity)
                .capacity(capacity).model(model)
                .build();
    }
}
