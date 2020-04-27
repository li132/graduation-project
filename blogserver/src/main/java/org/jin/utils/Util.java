package org.jin.utils;

import org.jin.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by jin on 2017/12/20.
 */
public class Util {
    public static User getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
