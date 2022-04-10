package za.ac.cput.factory;

import za.ac.cput.domain.entity.Contact;

import za.ac.cput.util.Helper;

public class ContactFactory {

    public static Contact CreateContact(String conId,String conNumber, String Description) {


        if (Helper.nullOrEmpty(conId) || Helper.nullOrEmpty(conNumber) || Helper.nullOrEmpty(Description)){
            return null;
        }


            return new Contact.Builder().setConId(conId)
                    .setConNumber(conNumber)
                    .setConDescription(Description)
                    .build();


    }
}
