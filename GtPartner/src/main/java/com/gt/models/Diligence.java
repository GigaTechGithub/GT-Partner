package com.gt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    
    

	public Diligence() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Diligence(Long id, String name, Integer status, Integer profileStatus) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.profileStatus = profileStatus;
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

	

	
    
}
