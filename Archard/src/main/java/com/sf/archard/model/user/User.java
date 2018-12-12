package com.sf.archard.model.user;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.sf.archard.model.charact.Charact;
import com.sf.archard.model.common.AuditModel;
import com.sf.archard.model.common.Ban;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "user")
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class User extends AuditModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "Invalid login")
	@Column(name = "login", nullable = false, unique = true)
	@Size(min = 3, message = "Login should have atleast 3 characters")
	private String login;

	@NotBlank(message = "Invalid email")
	@Email(message = "Invalid email format")
	@Size(min = 3, message = "Password should have atleast 3 characters")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotBlank(message = "Invalid password")
	@Size(min = 3, message = "Password should have atleast 3 characters")
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "banned", nullable = false, columnDefinition = "bit default 0")
	private boolean banned;

	@Column(name = "activated", nullable = false, columnDefinition = "bit default 0")
	private boolean activated;

	@OneToMany(mappedBy = "user")
	private List<Charact> characters;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private Ban ban;

}
