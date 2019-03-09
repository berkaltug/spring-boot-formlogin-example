package com.formlogin.main;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="users")
public class User
{
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(nullable=false, unique=true)
    private String email;
    @Column(nullable=false)
    private String password;
    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
          name="user_role",
          joinColumns={@JoinColumn(name="USER_ID",
                        referencedColumnName="ID")},
          inverseJoinColumns={@JoinColumn(name="ROLE_ID",
                        referencedColumnName="ID")})
    private List<Role> roles;
    //setters and getters
	public User(Integer id, String email, String password, List<Role> roles) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	public User() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
    
}