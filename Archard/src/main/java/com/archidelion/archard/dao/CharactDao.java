package com.archidelion.archard.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archidelion.archard.bean.charact.Charact;

public interface CharactDao extends JpaRepository<Charact, Long> {
	Charact getCharacterById(Long id);
}
