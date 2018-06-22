package com.archidelion.archard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.archidelion.archard.bean.charact.Charact;

public interface CharactDao extends JpaRepository<Charact, Long> {
	Charact getCharacterById(Long id);

	@Modifying
	@Query("insert into Charact (id, name) select :id, :name")
	Character addCharacter(@Param("name") String name, @Param("id") Long userId);
}
