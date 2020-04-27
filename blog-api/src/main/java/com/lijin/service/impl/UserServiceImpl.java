package com.lijin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.lijin.mapper.UserMapper;
import com.lijin.mapper.UserinfoMapper;
import com.lijin.pojo.UserExample;
import com.lijin.pojo.Userinfo;
import com.lijin.pojo.UserinfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lijin.common.util.PasswordHelper;
import com.lijin.pojo.User;
import com.lijin.service.UserService;

/**
 * @author lijin
 * <p>
 * 2018年1月23日
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User getUserByAccount(String account) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andAccountEqualTo(account);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.isEmpty() || users.size()==0){
            return null;
        }
        User user = users.get(0);
        return user;
    }

    @Override
    public User getUserById(Long id) {

        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Long saveUser(User user) {

        PasswordHelper.encryptPassword(user);
        int index = new Random().nextInt(6) + 1;
        String avatar = "/static/user/user_" + index + ".png";
        user.setAvatar(avatar);
        userMapper.save(user);
        Userinfo userinfo=new Userinfo();
        userinfo.setUserId(user.getId().intValue());
        userinfo.setLastDate(new Date());
        userinfoMapper.insert(userinfo);
        return user.getId();
    }


    @Override
    @Transactional
    public Long updateUser(User user) {
        User oldUser = userMapper.selectByPrimaryKey(user.getId());
        oldUser.setNickname(user.getNickname());
        userMapper.updateByPrimaryKey(oldUser);
        return oldUser.getId();
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Userinfo getUserInfo(Long id) {
        Userinfo userinfo = userinfoMapper.selectByUserId(id);
        return userinfo;
    }

    @Override
    public void updateUserInfo(User user, Userinfo userinfo) {
        userinfo.setLastDate(new Date());
        userMapper.updateByPrimaryKey(user);
        userinfoMapper.updateByPrimaryKey(userinfo);
    }

}
