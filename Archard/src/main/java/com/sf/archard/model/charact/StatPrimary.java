package com.sf.archard.model.charact;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "charact_stat_pmry")
public class StatPrimary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "skey")
	private String skey;

	@Column(name = "value")
	private float value;

	@Column(name = "max_value")
	private float maxValue;

	@Column(name = "min_value")
	private float minValue;

	@Column(name = "point")
	private int point;

	@ManyToOne
	@JoinColumn(name = "charact_id")
	@JsonIgnore
	private Charact charact;
}
