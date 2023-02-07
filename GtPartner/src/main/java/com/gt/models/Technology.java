package com.gt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_technology")
public class Technology {
	
	@Id
 	@Column(name="ID")
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="CREATED_BY")
    private Integer createdBy;
    
    @Column(name="DILIGENCE_ID")
    private Integer diligenceId;
    
    @Column(name="TECH1")
    private String tech1;
    
    @Column(name="TECH2")
    private String tech2;
    
    @Column(name="TECH3")
    private String tech3;
    
    @Column(name="TECH4")
    private String tech4;
    
    @Column(name="TECH5")
    private String tech5;
    
    @Column(name="TECH6")
    private String tech6;
    
    @Column(name="TECH7")
    private String tech7;
    
    @Column(name="TECH8")
    private String tech8;
    
    @Column(name="TECH9")
    private String tech9;
    
    @Column(name="TECH10")
    private String tech10;
    
    @Column(name="TECH11")
    private String tech11;
    
    @Column(name="TECH12")
    private String tech12;
    
    @Column(name="TECH13")
    private String tech13;
    
    @Column(name="TECH14")
    private String tech14;
    
    @Column(name="TECH15")
    private String tech15;
    
    @Column(name="TECH16")
    private String tech16;
    
    @Column(name="TECH17")
    private String tech17;
    
    @Column(name="TECH18")
    private String tech18;
    
    @Column(name="TECH19")
    private String tech19;
    
    @Column(name="TECH20")
    private String tech20;
    
    @Column(name="TECH21")
    private String tech21;
    
    @Column(name="TECH22")
    private String tech22;
    
    @Column(name="TECH23")
    private String tech23;
    
    @Column(name="TECH24")
    private String tech24;
    
    @Column(name="TECH25")
    private String tech25;
    
    @Column(name="TECH26")
    private String tech26;
    
    @Column(name="TECH27")
    private String tech27;
    
    @Column(name="TECH28")
    private String tech28;
    
    @Column(name="TECH29")
    private String tech29;
    
    @Column(name="TECH30")
    private String tech30;
    
    @Column(name="TECH31")
    private String tech31;
    
    @Column(name="TECH32")
    private String tech32;
    
    @Column(name="TECH33")
    private String tech33;
    
    @Column(name="TECH34")
    private String tech34;
    
    @Column(name="TECH35")
    private String tech35;
    
    @Column(name="TECH36")
    private String tech36;
    
    @Column(name="TECH37")
    private String tech37;
    
    @Column(name="TECH38")
    private String tech38;
    
    @Column(name="TECH39")
    private String tech39;
    
    @Column(name="TECH40")
    private String tech40;
    
    @Column(name="TECH41")
    private String tech41;
    
    @Column(name="TECH42")
    private String tech42;

	public Technology() {
		super();
	}

	public Technology(Long id, Integer createdBy, Integer diligenceId, String tech1, String tech2, String tech3,
			String tech4, String tech5, String tech6, String tech7, String tech8, String tech9, String tech10,
			String tech11, String tech12, String tech13, String tech14, String tech15, String tech16, String tech17,
			String tech18, String tech19, String tech20, String tech21, String tech22, String tech23, String tech24,
			String tech25, String tech26, String tech27, String tech28, String tech29, String tech30, String tech31,
			String tech32, String tech33, String tech34, String tech35, String tech36, String tech37, String tech38,
			String tech39, String tech40, String tech41, String tech42, String tech43) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.diligenceId = diligenceId;
		this.tech1 = tech1;
		this.tech2 = tech2;
		this.tech3 = tech3;
		this.tech4 = tech4;
		this.tech5 = tech5;
		this.tech6 = tech6;
		this.tech7 = tech7;
		this.tech8 = tech8;
		this.tech9 = tech9;
		this.tech10 = tech10;
		this.tech11 = tech11;
		this.tech12 = tech12;
		this.tech13 = tech13;
		this.tech14 = tech14;
		this.tech15 = tech15;
		this.tech16 = tech16;
		this.tech17 = tech17;
		this.tech18 = tech18;
		this.tech19 = tech19;
		this.tech20 = tech20;
		this.tech21 = tech21;
		this.tech22 = tech22;
		this.tech23 = tech23;
		this.tech24 = tech24;
		this.tech25 = tech25;
		this.tech26 = tech26;
		this.tech27 = tech27;
		this.tech28 = tech28;
		this.tech29 = tech29;
		this.tech30 = tech30;
		this.tech31 = tech31;
		this.tech32 = tech32;
		this.tech33 = tech33;
		this.tech34 = tech34;
		this.tech35 = tech35;
		this.tech36 = tech36;
		this.tech37 = tech37;
		this.tech38 = tech38;
		this.tech39 = tech39;
		this.tech40 = tech40;
		this.tech41 = tech41;
		this.tech42 = tech42;
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

	public String getTech1() {
		return tech1;
	}

	public void setTech1(String tech1) {
		this.tech1 = tech1;
	}

	public String getTech2() {
		return tech2;
	}

	public void setTech2(String tech2) {
		this.tech2 = tech2;
	}

	public String getTech3() {
		return tech3;
	}

	public void setTech3(String tech3) {
		this.tech3 = tech3;
	}

	public String getTech4() {
		return tech4;
	}

	public void setTech4(String tech4) {
		this.tech4 = tech4;
	}

	public String getTech5() {
		return tech5;
	}

	public void setTech5(String tech5) {
		this.tech5 = tech5;
	}

	public String getTech6() {
		return tech6;
	}

	public void setTech6(String tech6) {
		this.tech6 = tech6;
	}

	public String getTech7() {
		return tech7;
	}

	public void setTech7(String tech7) {
		this.tech7 = tech7;
	}

	public String getTech8() {
		return tech8;
	}

	public void setTech8(String tech8) {
		this.tech8 = tech8;
	}

	public String getTech9() {
		return tech9;
	}

	public void setTech9(String tech9) {
		this.tech9 = tech9;
	}

	public String getTech10() {
		return tech10;
	}

	public void setTech10(String tech10) {
		this.tech10 = tech10;
	}

	public String getTech11() {
		return tech11;
	}

	public void setTech11(String tech11) {
		this.tech11 = tech11;
	}

	public String getTech12() {
		return tech12;
	}

	public void setTech12(String tech12) {
		this.tech12 = tech12;
	}

	public String getTech13() {
		return tech13;
	}

	public void setTech13(String tech13) {
		this.tech13 = tech13;
	}

	public String getTech14() {
		return tech14;
	}

	public void setTech14(String tech14) {
		this.tech14 = tech14;
	}

	public String getTech15() {
		return tech15;
	}

	public void setTech15(String tech15) {
		this.tech15 = tech15;
	}

	public String getTech16() {
		return tech16;
	}

	public void setTech16(String tech16) {
		this.tech16 = tech16;
	}

	public String getTech17() {
		return tech17;
	}

	public void setTech17(String tech17) {
		this.tech17 = tech17;
	}

	public String getTech18() {
		return tech18;
	}

	public void setTech18(String tech18) {
		this.tech18 = tech18;
	}

	public String getTech19() {
		return tech19;
	}

	public void setTech19(String tech19) {
		this.tech19 = tech19;
	}

	public String getTech20() {
		return tech20;
	}

	public void setTech20(String tech20) {
		this.tech20 = tech20;
	}

	public String getTech21() {
		return tech21;
	}

	public void setTech21(String tech21) {
		this.tech21 = tech21;
	}

	public String getTech22() {
		return tech22;
	}

	public void setTech22(String tech22) {
		this.tech22 = tech22;
	}

	public String getTech23() {
		return tech23;
	}

	public void setTech23(String tech23) {
		this.tech23 = tech23;
	}

	public String getTech24() {
		return tech24;
	}

	public void setTech24(String tech24) {
		this.tech24 = tech24;
	}

	public String getTech25() {
		return tech25;
	}

	public void setTech25(String tech25) {
		this.tech25 = tech25;
	}

	public String getTech26() {
		return tech26;
	}

	public void setTech26(String tech26) {
		this.tech26 = tech26;
	}

	public String getTech27() {
		return tech27;
	}

	public void setTech27(String tech27) {
		this.tech27 = tech27;
	}

	public String getTech28() {
		return tech28;
	}

	public void setTech28(String tech28) {
		this.tech28 = tech28;
	}

	public String getTech29() {
		return tech29;
	}

	public void setTech29(String tech29) {
		this.tech29 = tech29;
	}

	public String getTech30() {
		return tech30;
	}

	public void setTech30(String tech30) {
		this.tech30 = tech30;
	}

	public String getTech31() {
		return tech31;
	}

	public void setTech31(String tech31) {
		this.tech31 = tech31;
	}

	public String getTech32() {
		return tech32;
	}

	public void setTech32(String tech32) {
		this.tech32 = tech32;
	}

	public String getTech33() {
		return tech33;
	}

	public void setTech33(String tech33) {
		this.tech33 = tech33;
	}

	public String getTech34() {
		return tech34;
	}

	public void setTech34(String tech34) {
		this.tech34 = tech34;
	}

	public String getTech35() {
		return tech35;
	}

	public void setTech35(String tech35) {
		this.tech35 = tech35;
	}

	public String getTech36() {
		return tech36;
	}

	public void setTech36(String tech36) {
		this.tech36 = tech36;
	}

	public String getTech37() {
		return tech37;
	}

	public void setTech37(String tech37) {
		this.tech37 = tech37;
	}

	public String getTech38() {
		return tech38;
	}

	public void setTech38(String tech38) {
		this.tech38 = tech38;
	}

	public String getTech39() {
		return tech39;
	}

	public void setTech39(String tech39) {
		this.tech39 = tech39;
	}

	public String getTech40() {
		return tech40;
	}

	public void setTech40(String tech40) {
		this.tech40 = tech40;
	}

	public String getTech41() {
		return tech41;
	}

	public void setTech41(String tech41) {
		this.tech41 = tech41;
	}

	public String getTech42() {
		return tech42;
	}

	public void setTech42(String tech42) {
		this.tech42 = tech42;
	}

	@Override
	public String toString() {
		return "Technology [id=" + id + ", createdBy=" + createdBy + ", diligenceId=" + diligenceId + ", tech1=" + tech1
				+ ", tech2=" + tech2 + ", tech3=" + tech3 + ", tech4=" + tech4 + ", tech5=" + tech5 + ", tech6=" + tech6
				+ ", tech7=" + tech7 + ", tech8=" + tech8 + ", tech9=" + tech9 + ", tech10=" + tech10 + ", tech11="
				+ tech11 + ", tech12=" + tech12 + ", tech13=" + tech13 + ", tech14=" + tech14 + ", tech15=" + tech15
				+ ", tech16=" + tech16 + ", tech17=" + tech17 + ", tech18=" + tech18 + ", tech19=" + tech19
				+ ", tech20=" + tech20 + ", tech21=" + tech21 + ", tech22=" + tech22 + ", tech23=" + tech23
				+ ", tech24=" + tech24 + ", tech25=" + tech25 + ", tech26=" + tech26 + ", tech27=" + tech27
				+ ", tech28=" + tech28 + ", tech29=" + tech29 + ", tech30=" + tech30 + ", tech31=" + tech31
				+ ", tech32=" + tech32 + ", tech33=" + tech33 + ", tech34=" + tech34 + ", tech35=" + tech35
				+ ", tech36=" + tech36 + ", tech37=" + tech37 + ", tech38=" + tech38 + ", tech39=" + tech39
				+ ", tech40=" + tech40 + ", tech41=" + tech41 + ", tech42=" + tech42 + ", tech43=" +  "]";
	}
    

    
}
