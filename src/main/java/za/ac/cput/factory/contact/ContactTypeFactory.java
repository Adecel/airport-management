package za.ac.cput.factory.contact;

import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.util.Helper;

public class ContactTypeFactory {

    public static ContactType build(String id, String email,String phoneNumber, String description) {
        Helper.checkStringParam("ContactTypeId", id);
        Helper.checkStringParam("email", email);  //validation (I have to search for a right wait)
        Helper.checkStringParam("phoneNumber", phoneNumber);
        Helper.checkStringParam("description", description);

        return ContactType.builder().id(id).email(email).phoneNumber(phoneNumber).description(description)
                .build();
    }

}
