package com.sf.archard.dao.charact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sf.archard.model.charact.StatPrimary;

@Repository
public interface CharacterStatPrimaryDao extends JpaRepository<StatPrimary, Long> {

}
