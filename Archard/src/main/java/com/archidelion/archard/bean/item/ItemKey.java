package com.archidelion.archard.bean.item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "item_key")
@EntityListeners(AuditingEntityListener.class)
@Data
public class ItemKey implements Serializable {
	private static final long serialVersionUID = 1L;

	public ItemKey() {

	}

	public ItemKey(String key) {
		this.key = key;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ik_id")
	private int id;

	@NotBlank(message = "Invalid item key id")
	@Size(min = 2, message = "Key id should have atleast 2 characters")
	@Column(name = "ik_key", unique = true)
	private String key;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "keyId")
	private List<Item> items = new ArrayList<Item>();

}
