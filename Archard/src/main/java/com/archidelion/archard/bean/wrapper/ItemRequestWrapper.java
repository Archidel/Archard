package com.archidelion.archard.bean.wrapper;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemRequestWrapper implements Serializable {
	private static final long serialVersionUID = 1L;
	private String itemKey;
	private int amount;
	private int slotIndex;
}
