package za.ac.cput.factory.user;
/*
  Adecel Rusty Mabiala
  219197229
 */
import za.ac.cput.domain.user.UserCategory;
import za.ac.cput.util.Helper;

public class UserCategoryFactory {

    public static UserCategory build(int id, String name, String description) {
        //Helper.checkStringParam("UserCategoryId", id);
        Helper.checkStringParam("name", name);
        Helper.checkStringParam("description", description);
        return UserCategory.builder().id(id).name(name).description(description)
                .build();
    }
}
