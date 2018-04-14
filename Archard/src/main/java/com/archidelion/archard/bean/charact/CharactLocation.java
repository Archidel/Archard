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
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "charact_location")
@EntityListeners(AuditingEntityListener.class)
@Data
public class CharactLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chl_id")
	private double chl_id;

	@NotBlank(message = "Invalid x coordinations")
	@Column(name = "chl_x", nullable = false)
	private double x;

	@NotBlank(message = "Invalid z coordinations")
	@Column(name = "chl_z", nullable = false)
	private double z;
	
	@NotBlank(message = "Invalid y coordinations")
	@Column(name = "chl_y", nullable = false)
	private double y;	
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ch_id")
	private Charact charact;
}
