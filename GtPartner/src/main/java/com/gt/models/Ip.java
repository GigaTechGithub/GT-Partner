package com.gt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_ip")
public class Ip {
	
	@Id
 	@Column(name="ID")
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="CREATED_BY")
    private Integer createdBy;
    
    @Column(name="DILIGENCE_ID")
    private Integer diligenceId;
    
    @Column(name="IP1")
    private String ip1;
    
    @Column(name="IP2")
    private String ip2;
    
    @Column(name="IP3")
    private String ip3;
    
    @Column(name="IP4")
    private String ip4;
    
    @Column(name="IP5")
    private String ip5;
    
    @Column(name="IP6")
    private String ip6;
    
    @Column(name="IP7")
    private String ip7;
    
    @Column(name="IP8")
    private String ip8;
    
    @Column(name="IP9")
    private String ip9;

	public Ip() {
		super();
	}

	public Ip(Long id, Integer createdBy, Integer diligenceId, String ip1, String ip2, String ip3, String ip4,
			String ip5, String ip6, String ip7, String ip8, String ip9) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.diligenceId = diligenceId;
		this.ip1 = ip1;
		this.ip2 = ip2;
		this.ip3 = ip3;
		this.ip4 = ip4;
		this.ip5 = ip5;
		this.ip6 = ip6;
		this.ip7 = ip7;
		this.ip8 = ip8;
		this.ip9 = ip9;
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

	public String getIp1() {
		return ip1;
	}

	public void setIp1(String ip1) {
		this.ip1 = ip1;
	}

	public String getIp2() {
		return ip2;
	}

	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}

	public String getIp3() {
		return ip3;
	}

	public void setIp3(String ip3) {
		this.ip3 = ip3;
	}

	public String getIp4() {
		return ip4;
	}

	public void setIp4(String ip4) {
		this.ip4 = ip4;
	}

	public String getIp5() {
		return ip5;
	}

	public void setIp5(String ip5) {
		this.ip5 = ip5;
	}

	public String getIp6() {
		return ip6;
	}

	public void setIp6(String ip6) {
		this.ip6 = ip6;
	}

	public String getIp7() {
		return ip7;
	}

	public void setIp7(String ip7) {
		this.ip7 = ip7;
	}

	public String getIp8() {
		return ip8;
	}

	public void setIp8(String ip8) {
		this.ip8 = ip8;
	}

	public String getIp9() {
		return ip9;
	}

	public void setIp9(String ip9) {
		this.ip9 = ip9;
	}

	@Override
	public String toString() {
		return "Ip [id=" + id + ", createdBy=" + createdBy + ", diligenceId=" + diligenceId + ", ip1=" + ip1 + ", ip2="
				+ ip2 + ", ip3=" + ip3 + ", ip4=" + ip4 + ", ip5=" + ip5 + ", ip6=" + ip6 + ", ip7=" + ip7 + ", ip8="
				+ ip8 + ", ip9=" + ip9 + "]";
	}
    
    

}
