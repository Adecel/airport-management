package za.ac.cput.factory.contact;


import za.ac.cput.domain.contact.UserContact;
import za.ac.cput.util.Helper;

public class UserContactFactory {

    public static UserContact build(int userId,  String date) {

        Helper.checkStringParam("date", date);

        return UserContact.builder().Id(userId)
        .date(date).build();
    }
}
