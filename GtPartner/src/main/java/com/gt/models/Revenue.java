package com.gt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity
@Table(name="T_revenue")
public class Revenue {
	
	@Id
 	@Column(name="ID")
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="CREATED_BY")
    private Integer createdBy;
    
    @Column(name="DILIGENCE_ID")
    private Integer diligenceId;

    @Column(name="REVENUE1")
    private Integer revenue1;
    
    @Column(name="REVENUE2")
    private Integer revenue2;
    
    @Column(name="REVENUE3")
    private Integer revenue3;
    
    @Column(name="REVENUE4")
    private Integer revenue4;

	public Revenue() {
		super();
	}

	public Revenue(Long id, Integer createdBy, Integer diligenceId, Integer revenue1, Integer revenue2,
			Integer revenue3, Integer revenue4) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.diligenceId = diligenceId;
		this.revenue1 = revenue1;
		this.revenue2 = revenue2;
		this.revenue3 = revenue3;
		this.revenue4 = revenue4;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getDiligenceId() {
		return diligenceId;
	}

	public void setDiligenceId(Integer diligenceId) {
		this.diligenceId = diligenceId;
	}

	public Integer getRevenue1() {
		return revenue1;
	}

	public void setRevenue1(Integer revenue1) {
		this.revenue1 = revenue1;
	}

	public Integer getRevenue2() {
		return revenue2;
	}

	public void setRevenue2(Integer revenue2) {
		this.revenue2 = revenue2;
	}

	public Integer getRevenue3() {
		return revenue3;
	}

	public void setRevenue3(Integer revenue3) {
		this.revenue3 = revenue3;
	}

	public Integer getRevenue4() {
		return revenue4;
	}

	public void setRevenue4(Integer revenue4) {
		this.revenue4 = revenue4;
	}

	@Override
	public String toString() {
		return "Revenue [id=" + id + ", createdBy=" + createdBy + ", diligenceId=" + diligenceId + ", revenue1="
				+ revenue1 + ", revenue2=" + revenue2 + ", revenue3=" + revenue3 + ", revenue4=" + revenue4 + "]";
	}
    
    
    
}
