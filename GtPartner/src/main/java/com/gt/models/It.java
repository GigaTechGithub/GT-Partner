package com.gt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_it")
public class It {
	
	@Id
 	@Column(name="ID")
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="CREATED_BY")
    private Integer createdBy;
    
    @Column(name="DILIGENCE_ID")
    private Integer diligenceId;
    
    @Column(name="IT1")
    private String it1;
    
    @Column(name="IT2")
    private String it2;
    
    @Column(name="IT3")
    private String it3;
    
    @Column(name="IT4")
    private String it4;
    
    @Column(name="IT5")
    private String it5;
    
    @Column(name="IT6")
    private String it6;
    
    @Column(name="IT7")
    private String it7;
    
    @Column(name="IT8")
    private String it8;
    
    @Column(name="IT9")
    private String it9;
    
    @Column(name="IT10")
    private String it10;

	public It() {
		super();
	}

	public It(Long id, Integer createdBy, Integer diligenceId, String it1, String it2, String it3, String it4,
			String it5, String it6, String it7, String it8, String it9, String it10) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.diligenceId = diligenceId;
		this.it1 = it1;
		this.it2 = it2;
		this.it3 = it3;
		this.it4 = it4;
		this.it5 = it5;
		this.it6 = it6;
		this.it7 = it7;
		this.it8 = it8;
		this.it9 = it9;
		this.it10 = it10;
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

	public String getIt1() {
		return it1;
	}

	public void setIt1(String it1) {
		this.it1 = it1;
	}

	public String getIt2() {
		return it2;
	}

	public void setIt2(String it2) {
		this.it2 = it2;
	}

	public String getIt3() {
		return it3;
	}

	public void setIt3(String it3) {
		this.it3 = it3;
	}

	public String getIt4() {
		return it4;
	}

	public void setIt4(String it4) {
		this.it4 = it4;
	}

	public String getIt5() {
		return it5;
	}

	public void setIt5(String it5) {
		this.it5 = it5;
	}

	public String getIt6() {
		return it6;
	}

	public void setIt6(String it6) {
		this.it6 = it6;
	}

	public String getIt7() {
		return it7;
	}

	public void setIt7(String it7) {
		this.it7 = it7;
	}

	public String getIt8() {
		return it8;
	}

	public void setIt8(String it8) {
		this.it8 = it8;
	}

	public String getIt9() {
		return it9;
	}

	public void setIt9(String it9) {
		this.it9 = it9;
	}

	public String getIt10() {
		return it10;
	}

	public void setIt10(String it10) {
		this.it10 = it10;
	}

	@Override
	public String toString() {
		return "It [id=" + id + ", createdBy=" + createdBy + ", diligenceId=" + diligenceId + ", it1=" + it1 + ", it2="
				+ it2 + ", it3=" + it3 + ", it4=" + it4 + ", it5=" + it5 + ", it6=" + it6 + ", it7=" + it7 + ", it8="
				+ it8 + ", it9=" + it9 + ", it10=" + it10 + "]";
	}
    
    

}
