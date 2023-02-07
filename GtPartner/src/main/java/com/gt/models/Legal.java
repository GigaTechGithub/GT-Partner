package com.gt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_legal")
public class Legal {
	
	@Id
 	@Column(name="ID")
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="DILIGENCE_ID")
    private Integer diligenceId;
     
    @Column(name="LEGAL1")
    private String legal1;
     
    @Column(name="LEGAL2")
    private String legal2;
    
    @Column(name="LEGAL3")
    private String legal3;
    
    @Column(name="LEGAL4")
    private String legal4;
    
    @Column(name="LEGAL5")
    private String legal5;
    
    @Column(name="LEGAL6")
    private String legal6;
    
    @Column(name="LEGAL7")
    private String legal7;
    
    @Column(name="LEGAL8")
    private String legal8;
    
    @Column(name="LEGAL9")
    private String legal9;
    
    @Column(name="LEGAL10")
    private String legal10;
    
    @Column(name="LEGAL11")
    private String legal11;
    
    @Column(name="LEGAL12")
    private String legal12;
    
    @Column(name="LEGAL13")
    private String legal13;
    
    @Column(name="LEGAL14")
    private String legal14;
    
    @Column(name="LEGAL15")
    private String legal15;
    
    @Column(name="LEGAL16")
    private String legal16;

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

	public String getLegal1() {
		return legal1;
	}

	public void setLegal1(String legal1) {
		this.legal1 = legal1;
	}

	public String getLegal2() {
		return legal2;
	}

	public void setLegal2(String legal2) {
		this.legal2 = legal2;
	}

	public String getLegal3() {
		return legal3;
	}

	public void setLegal3(String legal3) {
		this.legal3 = legal3;
	}

	public String getLegal4() {
		return legal4;
	}

	public void setLegal4(String legal4) {
		this.legal4 = legal4;
	}

	public String getLegal5() {
		return legal5;
	}

	public void setLegal5(String legal5) {
		this.legal5 = legal5;
	}

	public String getLegal6() {
		return legal6;
	}

	public void setLegal6(String legal6) {
		this.legal6 = legal6;
	}

	public String getLegal7() {
		return legal7;
	}

	public void setLegal7(String legal7) {
		this.legal7 = legal7;
	}

	public String getLegal8() {
		return legal8;
	}

	public void setLegal8(String legal8) {
		this.legal8 = legal8;
	}

	public String getLegal9() {
		return legal9;
	}

	public void setLegal9(String legal9) {
		this.legal9 = legal9;
	}

	public String getLegal10() {
		return legal10;
	}

	public void setLegal10(String legal10) {
		this.legal10 = legal10;
	}

	public String getLegal11() {
		return legal11;
	}

	public void setLegal11(String legal11) {
		this.legal11 = legal11;
	}

	public String getLegal12() {
		return legal12;
	}

	public void setLegal12(String legal12) {
		this.legal12 = legal12;
	}

	public String getLegal13() {
		return legal13;
	}

	public void setLegal13(String legal13) {
		this.legal13 = legal13;
	}

	public String getLegal14() {
		return legal14;
	}

	public void setLegal14(String legal14) {
		this.legal14 = legal14;
	}

	public String getLegal15() {
		return legal15;
	}

	public void setLegal15(String legal15) {
		this.legal15 = legal15;
	}

	public String getLegal16() {
		return legal16;
	}

	public void setLegal16(String legal16) {
		this.legal16 = legal16;
	}

	public Legal() {
		super();
	}

	public Legal(Long id, Integer diligenceId, String legal1, String legal2, String legal3, String legal4,
			String legal5, String legal6, String legal7, String legal8, String legal9, String legal10, String legal11,
			String legal12, String legal13, String legal14, String legal15, String legal16) {
		super();
		this.id = id;
		this.diligenceId = diligenceId;
		this.legal1 = legal1;
		this.legal2 = legal2;
		this.legal3 = legal3;
		this.legal4 = legal4;
		this.legal5 = legal5;
		this.legal6 = legal6;
		this.legal7 = legal7;
		this.legal8 = legal8;
		this.legal9 = legal9;
		this.legal10 = legal10;
		this.legal11 = legal11;
		this.legal12 = legal12;
		this.legal13 = legal13;
		this.legal14 = legal14;
		this.legal15 = legal15;
		this.legal16 = legal16;
	}

	@Override
	public String toString() {
		return "Legal [id=" + id + ", diligenceId=" + diligenceId + ", legal1=" + legal1 + ", legal2=" + legal2
				+ ", legal3=" + legal3 + ", legal4=" + legal4 + ", legal5=" + legal5 + ", legal6=" + legal6
				+ ", legal7=" + legal7 + ", legal8=" + legal8 + ", legal9=" + legal9 + ", legal10=" + legal10
				+ ", legal11=" + legal11 + ", legal12=" + legal12 + ", legal13=" + legal13 + ", legal14=" + legal14
				+ ", legal15=" + legal15 + ", legal16=" + legal16 + "]";
	}
    
    
    
}
