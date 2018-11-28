package com.sf.archard.item.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String key;

}
