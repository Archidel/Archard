package com.archidelion.archard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archidelion.archard.bean.charact.Charact;
import com.archidelion.archard.dao.CharactDao;
import com.archidelion.archard.service.CharactService;

@Service
public class CharactServiceImpl implements CharactService {

	@Autowired
	private CharactDao charactDao;

	@Override
	public Charact addCharacter(String name, int userId) {
		return charactDao.save(new Charact(name));
	}

	@Override
	public Charact getCharacterById(Long id) {
		return charactDao.getCharacterById(id);
	}

}
