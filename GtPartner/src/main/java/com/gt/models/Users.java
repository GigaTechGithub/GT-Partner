package com.gt.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_users")
public class Users {

	 @Id
	    @GeneratedValue
	    private Long id;
	     
	    @Column(name="name")
	    private String name;
	     
	    @Column(name="username", nullable=false, length=100)
	    private String username;
	     
	    @Column(name="password")
	    private String password;
	    
	    @Column(name="email")
	    private String email;
	    
	    @Column(name="mobile")
	    private String mobile;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
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

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		@Override
		public String toString() {
			return "Users [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
					+ ", email=" + email + ", mobile=" + mobile + "]";
		}
	    
	    
	    
}
