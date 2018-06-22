package com.archidelion.archard.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.archidelion.archard.bean.charact.Charact;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public User(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id")
	private Long id;

	@NotBlank(message = "Invalid login")
	@Column(name = "u_login", nullable = false, unique = true)
	@Size(min = 3, message = "Login should have atleast 3 characters")
	private String login;

	@NotBlank(message = "Invalid password")
	@Size(min = 3, message = "Password should have atleast 3 characters")
	@Column(name = "u_password", nullable = false)
	private String password;

	@NotBlank(message = "Invalid email")
	@Email(message = "Invalid email format")
	@Size(min = 3, message = "Password should have atleast 3 characters")
	@Column(name = "u_email", nullable = false, unique = true)
	private String email;

	@Column(name = "u_deleted")
	private boolean deleted;

	@Column(name = "u_banned")
	private boolean banned;

	@Column(name = "u_activated")
	private boolean activated;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Charact> characters;

}