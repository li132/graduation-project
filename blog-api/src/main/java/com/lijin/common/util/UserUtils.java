package com.lijin.common.util;

import org.apache.shiro.SecurityUtils;

import com.lijin.common.constant.Base;
import com.lijin.pojo.User;

/**
 * @author lijin
 * <p>
 * 2018年1月25日
 */
public class UserUtils {

    public static User getCurrentUser() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Base.CURRENT_USER);
        return user;
    }
}
