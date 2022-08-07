package za.ac.cput.factory.lookup;

/*
 * Author : Mahad Hassan
 * Student Number : 219122822
 * Capstone Project
 * Class: Contact.java
 * */
import za.ac.cput.domain.lookup.Contact;

import za.ac.cput.util.Helper;

public class ContactFactory {

    public static Contact CreateContact(String conId,String conNumber, String Description) {


        if (Helper.isEmptyOrNull(conId) || Helper.isEmptyOrNull(conNumber) || Helper.isEmptyOrNull(Description)){
            return null;
        }


            return new Contact.Builder().setConId(conId)
                    .setConNumber(conNumber)
                    .setConDescription(Description)
                    .build();


    }
}
