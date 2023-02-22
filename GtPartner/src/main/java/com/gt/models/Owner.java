package com.gt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_owner")
public class Owner {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="DILIGENCE_ID", nullable=false, length=20)
    private Integer diligenceId;
    
    @Column(name="CREATED_BY", nullable=false, length=20)
    private Integer createdBy;
     
    @Column(name="OWNER_NAME", nullable=false, length=100)
    private String ownerName;
    
    @Column(name="OWNER_SECOND_NAME", nullable=true, length=100)
    private String ownerSecondName;
     
    @Column(name="OWNER_PERCENT", nullable=false)
    private float ownerPercent;
    
    @Column(name="IS_SECOND_NAME")
    private String isSecondName;

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(Long id, Integer diligenceId, Integer createdBy, String ownerName, String ownerSecondName,
			float ownerPercent, String isSecondName) {
		super();
		this.id = id;
		this.diligenceId = diligenceId;
		this.createdBy = createdBy;
		this.ownerName = ownerName;
		this.ownerSecondName = ownerSecondName;
		this.ownerPercent = ownerPercent;
		this.isSecondName = isSecondName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDiligenceId() {
		return diligenceId;
	}

	public void setDiligenceId(Integer diligenceId) {
		this.diligenceId = diligenceId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerSecondName() {
		return ownerSecondName;
	}

	public void setOwnerSecondName(String ownerSecondName) {
		this.ownerSecondName = ownerSecondName;
	}

	public float getOwnerPercent() {
		return ownerPercent;
	}

	public void setOwnerPercent(float ownerPercent) {
		this.ownerPercent = ownerPercent;
	}

	public String getIsSecondName() {
		return isSecondName;
	}

	public void setIsSecondName(String isSecondName) {
		this.isSecondName = isSecondName;
	}

	
}
