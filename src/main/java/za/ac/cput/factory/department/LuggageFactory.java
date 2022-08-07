package za.ac.cput.factory.department;

//219383448 KISSIMBA NYEMBO ISAAC


import za.ac.cput.domain.department.Luggage;
import za.ac.cput.util.Helper;


public class LuggageFactory {
    public static Luggage build(String luggageID, String luggageNumber, String luggageType) {
        Helper.checkStringParam("luggageID", luggageID);
        Helper.checkStringParam("luggageNumber", luggageNumber);
        Helper.checkStringParam("luggageType", luggageType);
        return new Luggage.Builder().BuildLuggageID(luggageID)
                .BuildLuggageNumber(luggageNumber)
                .BuildLuggageType(luggageType)
                .build();
    }

    }


