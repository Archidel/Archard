package com.sf.archard.model.charact;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sf.archard.model.common.AuditModel;
import com.sf.archard.model.user.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "charact")
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class Charact extends AuditModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@NotBlank(message = "Invalid character name")
	@Column(name = "name", nullable = false, unique = true)
	@Size(min = 3, message = "Name should have atleast 3 characters")
	private String name;

	@Column(name = "experience", nullable = false, columnDefinition = "int default 0")
	private int experience;

	@OneToOne(mappedBy = "charact", cascade = CascadeType.ALL)
	private CharactLocation characterLocation;

	@OneToMany(mappedBy = "charact")
	private List<StatPrimary> stats;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", columnDefinition = "varchar(32) default 'OFFLINE'")
	private CharactStatus status;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	public Charact(long id) {
		this.id = id;
	}

	public Charact() {
	}

	public Charact(
			@NotBlank(message = "Invalid character name") @Size(min = 3, message = "Name should have atleast 3 characters") String name) {
		this.name = name;
	}

	public Charact(long id, User user) {
		this.id = id;
		this.user = user;
	}

	public Charact(long id, CharactStatus status, User user) {
		this.id = id;
		this.status = status;
		this.user = user;
	}

}
