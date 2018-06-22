package com.archidelion.archard.service;

import com.archidelion.archard.bean.charact.Charact;

public interface CharactService {
	Charact addCharacter(String name, Long userId);

	Charact getCharacterById(Long id);
}
