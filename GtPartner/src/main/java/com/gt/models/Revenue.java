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
    private String revenue1;
    
    @Column(name="REVENUE2")
    private String revenue2;
    
    @Column(name="REVENUE3")
    private String revenue3;
    
    @Column(name="REVENUE4")
    private String revenue4;

	public Revenue() {
		super();
	}

	public Revenue(Long id, Integer createdBy, Integer diligenceId, String revenue1, String revenue2, String revenue3,
			String revenue4) {
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

	public String getRevenue1() {
		return revenue1;
	}

	public void setRevenue1(String revenue1) {
		this.revenue1 = revenue1;
	}

	public String getRevenue2() {
		return revenue2;
	}

	public void setRevenue2(String revenue2) {
		this.revenue2 = revenue2;
	}

	public String getRevenue3() {
		return revenue3;
	}

	public void setRevenue3(String revenue3) {
		this.revenue3 = revenue3;
	}

	public String getRevenue4() {
		return revenue4;
	}

	public void setRevenue4(String revenue4) {
		this.revenue4 = revenue4;
	}    
    
    
}
