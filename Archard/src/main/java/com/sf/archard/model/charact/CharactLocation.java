package com.sf.archard.model.charact;

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
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "charact_location")
@EntityListeners(AuditingEntityListener.class)
public class CharactLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "x", nullable = false)
	private float x;

	@Column(name = "z", nullable = false)
	private float z;

	@Column(name = "y", nullable = false)
	private float y;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "character_id")
	@JsonIgnore
	private Charact charact;
}
