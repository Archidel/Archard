package com.archidelion.archard.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archidelion.archard.bean.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getUserByLoginAndPassword(String login, String password);
}
