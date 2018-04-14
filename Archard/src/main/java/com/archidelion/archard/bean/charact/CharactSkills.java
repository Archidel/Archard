package com.archidelion.archard.bean.charact;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "charact_skills")
@EntityListeners(AuditingEntityListener.class)
@Data
public class CharactSkills implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chsk_id")
	private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ch_id")
	private Charact charact;

	public CharactSkills() {

	}
}
