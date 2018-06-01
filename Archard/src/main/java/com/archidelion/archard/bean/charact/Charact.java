package com.archidelion.archard.bean.charact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.archidelion.archard.bean.User;
import com.archidelion.archard.bean.item.Item;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "charact")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "user" }, allowGetters = true)
@Data
public class Charact implements Serializable {
	private static final long serialVersionUID = 1L;

	public Charact(String name) {
		this.name = name;
	}

	public Charact() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ch_id")
	private int id;

	@NotBlank(message = "Invalid character name")
	@Column(name = "ch_name", nullable = false, unique = true)
	@Size(min = 3, message = "Name should have atleast 3 characters")
	private String name;

	@Column(name = "ch_banned")
	private boolean banned;

	@Column(name = "ch_status")
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "u_id")
	private User user;

	@OneToOne(mappedBy = "charact", cascade = CascadeType.ALL)
	private CharactLocation characterLocation;

	@OneToMany(mappedBy = "charact")
	private List<CharactSkill> charactSkills;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "charact_has_item", joinColumns = { @JoinColumn(name = "i_id") }, inverseJoinColumns = {
			@JoinColumn(name = "ch_id") })
	private List<Item> items = new ArrayList<Item>();

}
