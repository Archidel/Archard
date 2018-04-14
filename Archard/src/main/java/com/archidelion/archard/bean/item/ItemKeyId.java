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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "item_keyid")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "user" }, allowGetters = true)
@Data
public class ItemKeyId implements Serializable {
	private static final long serialVersionUID = 1L;

	public ItemKeyId() {
	}

	public ItemKeyId(String itemKeyId) {
		this.itemKeyId = itemKeyId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iki_id")
	private int id;

	@NotBlank(message = "Invalid item key id")
	@Column(name = "iki_key", nullable = false, unique = true)
	@Size(min = 2, message = "Key id should have atleast 2 characters")
	private String itemKeyId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "keyId")
	private List<Item> items = new ArrayList<Item>();

}
