package com.archidelion.archard.bean.item;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.archidelion.archard.bean.charact.Charact;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "item")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "user" }, allowGetters = true)
@Data
@ToString
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_id")
	private Long id;

	@Column(name = "i_key")
	private String key;

	@Column(name = "i_amount")
	private int amount;

	@Column(name = "i_slot_type")
	private String slotType;

	@Column(name = "i_slot_index")
	private int slotIndex;

	@ManyToOne
	@JoinColumn(name = "ch_id", nullable = false)
	private Charact charact;

	public Item() {
	}

}
