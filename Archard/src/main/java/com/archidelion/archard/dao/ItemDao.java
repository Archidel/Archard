package com.archidelion.archard.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archidelion.archard.bean.item.Item;

public interface ItemDao extends JpaRepository<Item, Integer> {

}
