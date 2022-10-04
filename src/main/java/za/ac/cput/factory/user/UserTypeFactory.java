package za.ac.cput.factory.user;

import za.ac.cput.domain.user.UserType;
import za.ac.cput.util.Helper;

public class UserTypeFactory {
    public static UserType build(String userId, String userCategoryId) {
        Helper.checkStringParam("userId", userId);
        Helper.checkStringParam("userCategoryId", userCategoryId);
        return UserType.builder().userId(userId).userCategoryId(userCategoryId)
                .build();
    }
}
