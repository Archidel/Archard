package com.archidelion.archard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archidelion.archard.bean.User;
import com.archidelion.archard.bean.charact.Charact;
import com.archidelion.archard.dao.CharactDao;
import com.archidelion.archard.dao.UserDao;
import com.archidelion.archard.service.CharactService;

@Service
public class CharactServiceImpl implements CharactService {

	@Autowired
	private CharactDao charactDao;

	@Autowired
	private UserDao userDao;

	@Override
	public Charact addCharacter(String name, Long userId) {
		Integer asd = (Integer) ((int)(long) userId);
		User user = userDao.getOne(asd);
		
//		Charact charact = new Charact(name);
//		System.out.println((int) (long) userId);
//		Integer iter = (int) (long) userId;
//		User user = userDao.findB
//		charact.setUser(user);
//		return charactDao.save(charact);
		return null;
	}

	@Override
	public Charact getCharacterById(Long id) {
		return charactDao.getCharacterById(id);
	}

}
