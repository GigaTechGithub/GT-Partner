package com.gt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="T_Diligence")
public class Diligence {
	@Id
 	@Column(name="ID")
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="DILIGENCE_NAME")
    private String name;
    
    @Column(name="STATUS")
    private Integer status;
    
    @Column(name="PROFILE_STATUS")
    private Integer profileStatus;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="MOBILE")
    private String mobile;
    
    @Column(name="WEBSITE")
    private String website;
    
    @Column(name="ADDRESS")
    private String address;
    
    @Column(name="CREATED_BY")
    private String createdBy;
    
	public Diligence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diligence(Long id, String name, Integer status, Integer profileStatus, String email, String mobile,
			String website, String address, String createdBy) {
		
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.profileStatus = profileStatus;
		this.email = email;
		this.mobile = mobile;
		this.website = website;
		this.address = address;
		this.createdBy = createdBy;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getProfileStatus() {
		return profileStatus;
	}

	public void setProfileStatus(Integer profileStatus) {
		this.profileStatus = profileStatus;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
