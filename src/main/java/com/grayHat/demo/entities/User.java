package com.grayHat.demo.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import com.grayHat.demo.entities.enums.UserRoles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "tb_user")
public class User implements Serializable, UserDetails {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable=false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String phone;

	@Column(nullable=false)
	private UserRoles role;
	
	@OneToMany(mappedBy = "client")
	@JsonManagedReference
	private List<Order> orders = new ArrayList<>();
	
	public User() {
	}

	public User(String username, String password, String email, String phone, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.role = UserRoles.valueOf(role);
	}
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UserRoles.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserRoles getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = UserRoles.valueOf(role);
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
