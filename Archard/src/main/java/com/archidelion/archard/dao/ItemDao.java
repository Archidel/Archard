package com.archidelion.archard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.archidelion.archard.bean.item.Item;

public interface ItemDao extends JpaRepository<Item, Long> {
	@Modifying
	@Query("delete from Item it where it.charact.id = ?1")
	void clearInventory(Long characterId);
}
