package za.ac.cput.factory.contact;
/*
  Hilary Cassidy Nguepi Nangmo
  220346887
*/

import za.ac.cput.domain.contact.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {

    public static Contact build(int id, String contact, String description) {
        Helper.checkStringParam("contact", contact);
        Helper.checkStringParam("description", description);

        return Contact.builder().id(id).contact(contact).description(description)
                .build();
    }
}
