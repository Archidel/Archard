package com.archidelion.archard.bean.charact;

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

import lombok.Data;

@Entity
@Table(name = "charact_skills")
@EntityListeners(AuditingEntityListener.class)
@Data
public class CharactSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	public CharactSkill() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chsk_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ch_id")
	private Charact charact;

	@Column(name = "chsk_name")
	private String name;

	@Column(name = "chsk_value")
	private int value;

}
