package com.archidelion.archard.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archidelion.archard.bean.item.ItemKey;

public interface ItemKeyDao extends JpaRepository<ItemKey, Integer> {
	ItemKey getByKey(String key);
}
