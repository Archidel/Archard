package com.sf.archard.service.charact;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.archard.common.exception.NotFoundException;
import com.sf.archard.dao.charact.CharactDao;
import com.sf.archard.model.charact.Charact;

@Service
public class CharactService {

	@Autowired
	private CharactDao charactDao;

	public Charact getCharacterById(Long userId, Long charactId) {
		Charact charact = charactDao.getCharacterById(userId, charactId);

		if (charact == null) {
			throw new NotFoundException("Character not found");
		}

		return charact;
	}

	public List<Charact> getCharacters(Long userId) {
		return charactDao.getCharacters(userId);
	}

}
