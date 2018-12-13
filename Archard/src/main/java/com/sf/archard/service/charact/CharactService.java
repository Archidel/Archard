package com.sf.archard.service.charact;

import static java.lang.String.format;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.archard.common.exception.NotFoundException;
import com.sf.archard.common.exception.ServiceException;
import com.sf.archard.dao.charact.CharactDao;
import com.sf.archard.dao.charact.CharacterLocationDao;
import com.sf.archard.dao.charact.CharacterStatPrimaryDao;
import com.sf.archard.model.charact.Charact;
import com.sf.archard.model.charact.CharactLocation;
import com.sf.archard.model.charact.StatPrimary;
import com.sf.archard.model.user.User;

@Service
public class CharactService {

	@Autowired
	private CharactDao charactDao;
	
	@Autowired
	private CharacterLocationDao characterLocationDao;

	@Autowired
	private CharacterStatPrimaryDao statPrimaryDao;

	public Charact getCharacterById(Long userId, Long charactId) {
		return charactDao.getCharacterById(userId, charactId)
				.orElseThrow(() -> new NotFoundException("Character not found"));
	}

	public List<Charact> getCharacters(Long userId) {
		return charactDao.getCharacters(userId);
	}

	public Charact addCharacter(Long userId, Charact charact) {
		boolean characterExist = charactDao.existsByName(charact.getName());

		if (characterExist) {
			throw new ServiceException("Character name is already taken");
		}

		charact.setUser(new User(userId));
		return charactDao.save(charact);
	}

	public Charact getByName(String name) {
		return charactDao.getByName(name)
				.orElseThrow(() -> new NotFoundException(format("Character with id [%s] not found", name)));
	}

	public void deleteCharacterById(Long userId, Long charactId) {
		Charact charact = new Charact(charactId, new User(userId));
		charactDao.delete(charact);
	}

	public List<StatPrimary> updateStats(Long userId, Long charactId, List<StatPrimary> stats) {
		stats.stream().forEach(s -> s.setCharact(new Charact(charactId)));
		return statPrimaryDao.saveAll(stats);
	}

	public void updateLocation(Long userId, Long charactId, CharactLocation location) {
		location.setCharact(new Charact(charactId));
		characterLocationDao.save(location);
	}
}
