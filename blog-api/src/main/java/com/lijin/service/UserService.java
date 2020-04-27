package com.lijin.service;

import java.util.List;

import com.lijin.pojo.User;
import com.lijin.pojo.Userinfo;

/**
 * @author lijin
 * <p>
 * 2018年1月23日
 */
public interface UserService {

    List<User> findAll();

    User getUserByAccount(String account);

    User getUserById(Long id);

    Long saveUser(User user);

    Long updateUser(User user);

    void deleteUserById(Long id);

    Userinfo getUserInfo(Long id);

    void updateUserInfo(User user, Userinfo userinfo);
}
