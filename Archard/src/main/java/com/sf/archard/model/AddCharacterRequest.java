package com.sf.archard.model;

import lombok.Data;

@Data
public class AddCharacterRequest {
	private Long userId;
	private String characterName;
}
