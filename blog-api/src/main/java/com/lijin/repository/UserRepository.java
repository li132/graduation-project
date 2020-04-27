package com.lijin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lijin.entity.User;

/**
 * @author lijin
 * <p>
 * 2018年1月23日
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByAccount(String account);

}
