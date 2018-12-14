package com.sf.archard.dao.charact;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sf.archard.model.charact.Charact;
import com.sf.archard.model.charact.CharactStatus;

@Repository
public interface CharactDao extends JpaRepository<Charact, Long> {

	@Query("select ch from Charact ch where ch.id = :characterId and ch.user.id = :userId")
	Optional<Charact> getCharacterById(@Param("userId") Long userId, @Param("characterId") Long charactId);

	@Query("select ch from Charact ch where ch.user.id = :userId")
	ArrayList<Charact> getCharacters(@Param("userId") Long userId);

	Optional<Charact> getByName(String name);

	boolean existsByName(String name);

	@Transactional
	@Modifying
	@Query("update Charact ch set ch.status = :status where ch.id = :charactId")
	void updateStatus(@Param("charactId") Long charactId, @Param("status") CharactStatus status);
}
