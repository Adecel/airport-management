package za.ac.cput.factory.contact;


import za.ac.cput.domain.contact.UserContact;
import za.ac.cput.util.Helper;

public class UserContactFactory {

    public static UserContact build(String userId, String contactTypeId, String contactId, String date) {
        Helper.checkStringParam("userId", userId);
        Helper.checkStringParam("contactTypeId", contactTypeId);
        Helper.checkStringParam("contactId", contactId);
        Helper.checkStringParam("date", date);

        return UserContact.builder().userId(userId).contactTypeId(contactTypeId)
                .contactId(contactId).date(date).build();
    }
}
