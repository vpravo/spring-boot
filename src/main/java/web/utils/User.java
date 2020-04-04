package web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import web.service.UserServiceImp;

public class User {
    @Autowired
    UserServiceImp userServiceImp;

    public static User getCurrentUser(String email){
        return null;
    }
}
