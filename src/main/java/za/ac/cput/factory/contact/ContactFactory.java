package za.ac.cput.factory.contact;


import za.ac.cput.domain.contact.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {

    public static Contact build(String id, String contact, String description) {
        Helper.checkStringParam("contactId", id);
        Helper.checkStringParam("contact", contact);
        Helper.checkStringParam("description", description);

        return Contact.builder().id(id).contact(contact).description(description)
                .build();
    }
}
