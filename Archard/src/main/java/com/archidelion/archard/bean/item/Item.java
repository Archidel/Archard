package com.archidelion.archard.bean.item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.archidelion.archard.bean.charact.Charact;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "item")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "user" }, allowGetters = true)
@Data
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_id")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ik_id", nullable = false)
	private ItemKey keyId;

	@Column(name = "i_amount")
	private int amount;

	@Column(name = "i_slot_index")
	private int slotIndex;

	@ManyToMany(mappedBy = "items")
	private List<Charact> characts = new ArrayList<Charact>();

	public Item() {
	}

	public Item(ItemKey itemKey, int amount, int slotIndex) {
	}

}
