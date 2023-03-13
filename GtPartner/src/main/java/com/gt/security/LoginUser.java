package com.gt.security;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="T_users")
public class LoginUser  implements UserDetails{
	
	@Id
 	@Column(name="ID")
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="NAME")
    private String name;
     
    @Column(name="USERNAME", nullable=false, length=100)
    private String username;
     
    @Column(name="PASSWORD")
    private String password;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="MOBILE")
    private String mobile;
    
    @Column(name="DILIGENCE_ID", nullable=false, length=20)
    private String diligenceId;
    
    @Formula("(select T_DILIGENCE.DILIGENCE_NAME from T_DILIGENCE where T_DILIGENCE.ID = DILIGENCE_ID)")
    private String companyName;
    
    @Column(name="STATUS")
    private int status;
    
    @Column(name="ISADMIN")
    private String isAdmin;
    
    @Column(name="CREATED_BY")
    private String createdBy;
    
    @Column(name="UPDATED_BY")
    private String updatedBy;
    
    @Column(name="ROLE")
    private Integer role;
   
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public LoginUser() {
		super();
	}

	public LoginUser(Long id, String name, String username, String password, String email, String mobile,
			String diligenceId, String companyName, int status, String isAdmin, String createdBy, String updatedBy,
			Integer role) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.diligenceId = diligenceId;
		this.companyName = companyName;
		this.status = status;
		this.isAdmin = isAdmin;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.role = role;
	}

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

	public String getDiligenceId() {
		return diligenceId;
	}

	public void setDiligenceId(String diligenceId) {
		this.diligenceId = diligenceId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    

    


	


	
	
}
