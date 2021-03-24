package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleEntity extends BasicEntitySuper{
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="role_id"),
	inverseJoinColumns = @JoinColumn (name="user_id"))
	private List<UserEntity> user;

	public List<UserEntity> getUsers() {
		return user;
	}

	public void setUsers(List<UserEntity> user) {
		this.user = user;
	}
}
