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
    private String diligenceId;
    
    @Column(name="CREATED_BY", nullable=false, length=20)
    private String createdBy;
     
    @Column(name="OWNER_NAME", nullable=false, length=100)
    private String ownerName;
    
    @Column(name="OWNER_SECOND_NAME", nullable=true, length=100)
    private String ownerSecondName;
     
    @Column(name="OWNER_PERCENT", nullable=false)
    private float ownerPercent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiligenceId() {
		return diligenceId;
	}

	public void setDiligenceId(String diligenceId) {
		this.diligenceId = diligenceId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
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

	public Owner() {
		super();
	}

	public Owner(Long id, String diligenceId, String createdBy, String ownerName, String ownerSecondName,
			float ownerPercent) {
		super();
		this.id = id;
		this.diligenceId = diligenceId;
		this.createdBy = createdBy;
		this.ownerName = ownerName;
		this.ownerSecondName = ownerSecondName;
		this.ownerPercent = ownerPercent;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", diligenceId=" + diligenceId + ", createdBy=" + createdBy + ", ownerName="
				+ ownerName + ", ownerSecondName=" + ownerSecondName + ", ownerPercent=" + ownerPercent + "]";
	}

	
    
}
