package com.gt.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_company")
public class Company {
	
//	private List<Bod> getBod;
//    private List<Owner> getOwner;
	
	@Id
 	@Column(name="ID")
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="ADDRESS", nullable=false, length=100)
    private String address;
     
    @Column(name="COMPANY_NAME", nullable=false, length=255)
    private String companyName;
    
    @Column(name="COMPANY_SECOND_NAME", nullable=true, length=255)
    private String companySecondName;
    
    @Column(name="COUNTRY", nullable=false, length=50)
    private String country;
    
    @Column(name="CREATED_BY", nullable=false, length=20)
    private Integer createdBy;
    
    @Column(name="DILIGENCE_ID", nullable=false, length=20)
    private Integer diligenceId;

    @Column(name="ETHICAL_1", nullable=false, length=100)
    private String ethical1;
    
    @Column(name="ETHICAL_2", nullable=false, length=100)
    private String ethical2;
    
    @Column(name="EXPORT_1", nullable=false, length=100)
    private String export1;
     
    @Column(name="EXPORT_2", nullable=false, length=100)
    private String export2;
    
    @Column(name="INCORPORATION_DATE", nullable=false, length=6)
    private LocalDate incorporation_date;
    
    @Column(name="IS_GOV", nullable=false, length=100)
    private String isGov;
     
    @Column(name="IS_GOV_CON", nullable=false, length=100)
    private String isGovCon;
    
    @Column(name="NO_OF_BOD", nullable=false, length=100)
    private Integer noOfBod;
    
    @Column(name="NO_OF_EMPLOYEES", nullable=false, length=20)
    private String noOfEmployees;
    
    @Column(name="PARENT_COMPANY_GLOBAL_LOCATION", nullable=true, length=100)
    private String parentCompanyGlobalLocation;
    
    @Column(name="PARENT_COMPANY_GLOBAL_NAME", nullable=true, length=100)
    private String parentCompanyGlobalName;
    
    @Column(name="PARENT_COMPANY_LOCATION", nullable=true, length=255)
    private String parentCompanyLocation;
    
    @Column(name="PARENT_COMPANY_NAME", nullable=true, length=255)
    private String parentCompanyName;
    
    @Column(name="PARENT_COMPANY_SECOND_GLOBAL_NAME", nullable=true, length=100)
    private String parentCompanySecondGlobalName;
    
    @Column(name="PARENT_COMPANY_SECOND_NAME", nullable=true, length=100)
    private String parentCompanySecondName;
    
    @Column(name="PERSONAL_CONNECTION", nullable=false, length=255)
    private String personalConnection;
    
    @Column(name="PROVINCE", nullable=true, length=50)
    private String province;
    
    @Column(name="SECOND_ADDRESS", nullable=true, length=100)
    private String secondAddress;
    
    @Column(name="TAX_ID", nullable=false, length=50)
    private String taxId;
    
    @Column(name="TELEPHONE", nullable=false, length=20)
    private String telephone;
    
    @Column(name="WEBSITE", nullable=true, length=50)
    private String website;
    
    @Column(name="IS_COMPANY_SECOND_NAME", nullable=true, length=255)
    private String isCompanySecondName;
    
    @Column(name="IS_SECOND_ADDRESS", nullable=true, length=255)
    private String isSecondAddress;
    
    @Column(name="IS_PARENT_COMPANY_SECOND_NAME", nullable=true, length=255)
    private String isParentCopanySecondName;
    
    @Column(name="IS_PARENT_COMPANY_SECOND_GLOBAL_NAME", nullable=true, length=255)
    private String isParentCompanySecondGlobalName;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(Long id, String address, String companyName, String companySecondName, String country,
			Integer createdBy, Integer diligenceId, String ethical1, String ethical2, String export1, String export2,
			LocalDate incorporation_date, String isGov, String isGovCon, Integer noOfBod, String noOfEmployees,
			String parentCompanyGlobalLocation, String parentCompanyGlobalName, String parentCompanyLocation,
			String parentCompanyName, String parentCompanySecondGlobalName, String parentCompanySecondName,
			String personalConnection, String province, String secondAddress, String taxId, String telephone,
			String website, String isCompanySecondName, String isSecondAddress, String isParentCopanySecondName,
			String isParentCompanySecondGlobalName) {
		super();
		this.id = id;
		this.address = address;
		this.companyName = companyName;
		this.companySecondName = companySecondName;
		this.country = country;
		this.createdBy = createdBy;
		this.diligenceId = diligenceId;
		this.ethical1 = ethical1;
		this.ethical2 = ethical2;
		this.export1 = export1;
		this.export2 = export2;
		this.incorporation_date = incorporation_date;
		this.isGov = isGov;
		this.isGovCon = isGovCon;
		this.noOfBod = noOfBod;
		this.noOfEmployees = noOfEmployees;
		this.parentCompanyGlobalLocation = parentCompanyGlobalLocation;
		this.parentCompanyGlobalName = parentCompanyGlobalName;
		this.parentCompanyLocation = parentCompanyLocation;
		this.parentCompanyName = parentCompanyName;
		this.parentCompanySecondGlobalName = parentCompanySecondGlobalName;
		this.parentCompanySecondName = parentCompanySecondName;
		this.personalConnection = personalConnection;
		this.province = province;
		this.secondAddress = secondAddress;
		this.taxId = taxId;
		this.telephone = telephone;
		this.website = website;
		this.isCompanySecondName = isCompanySecondName;
		this.isSecondAddress = isSecondAddress;
		this.isParentCopanySecondName = isParentCopanySecondName;
		this.isParentCompanySecondGlobalName = isParentCompanySecondGlobalName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanySecondName() {
		return companySecondName;
	}

	public void setCompanySecondName(String companySecondName) {
		this.companySecondName = companySecondName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getEthical1() {
		return ethical1;
	}

	public void setEthical1(String ethical1) {
		this.ethical1 = ethical1;
	}

	public String getEthical2() {
		return ethical2;
	}

	public void setEthical2(String ethical2) {
		this.ethical2 = ethical2;
	}

	public String getExport1() {
		return export1;
	}

	public void setExport1(String export1) {
		this.export1 = export1;
	}

	public String getExport2() {
		return export2;
	}

	public void setExport2(String export2) {
		this.export2 = export2;
	}

	public LocalDate getIncorporation_date() {
		return incorporation_date;
	}

	public void setIncorporation_date(LocalDate incorporation_date) {
		this.incorporation_date = incorporation_date;
	}

	public String getIsGov() {
		return isGov;
	}

	public void setIsGov(String isGov) {
		this.isGov = isGov;
	}

	public String getIsGovCon() {
		return isGovCon;
	}

	public void setIsGovCon(String isGovCon) {
		this.isGovCon = isGovCon;
	}

	public Integer getNoOfBod() {
		return noOfBod;
	}

	public void setNoOfBod(Integer noOfBod) {
		this.noOfBod = noOfBod;
	}

	public String getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(String noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public String getParentCompanyGlobalLocation() {
		return parentCompanyGlobalLocation;
	}

	public void setParentCompanyGlobalLocation(String parentCompanyGlobalLocation) {
		this.parentCompanyGlobalLocation = parentCompanyGlobalLocation;
	}

	public String getParentCompanyGlobalName() {
		return parentCompanyGlobalName;
	}

	public void setParentCompanyGlobalName(String parentCompanyGlobalName) {
		this.parentCompanyGlobalName = parentCompanyGlobalName;
	}

	public String getParentCompanyLocation() {
		return parentCompanyLocation;
	}

	public void setParentCompanyLocation(String parentCompanyLocation) {
		this.parentCompanyLocation = parentCompanyLocation;
	}

	public String getParentCompanyName() {
		return parentCompanyName;
	}

	public void setParentCompanyName(String parentCompanyName) {
		this.parentCompanyName = parentCompanyName;
	}

	public String getParentCompanySecondGlobalName() {
		return parentCompanySecondGlobalName;
	}

	public void setParentCompanySecondGlobalName(String parentCompanySecondGlobalName) {
		this.parentCompanySecondGlobalName = parentCompanySecondGlobalName;
	}

	public String getParentCompanySecondName() {
		return parentCompanySecondName;
	}

	public void setParentCompanySecondName(String parentCompanySecondName) {
		this.parentCompanySecondName = parentCompanySecondName;
	}

	public String getPersonalConnection() {
		return personalConnection;
	}

	public void setPersonalConnection(String personalConnection) {
		this.personalConnection = personalConnection;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getSecondAddress() {
		return secondAddress;
	}

	public void setSecondAddress(String secondAddress) {
		this.secondAddress = secondAddress;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getIsCompanySecondName() {
		return isCompanySecondName;
	}

	public void setIsCompanySecondName(String isCompanySecondName) {
		this.isCompanySecondName = isCompanySecondName;
	}

	public String getIsSecondAddress() {
		return isSecondAddress;
	}

	public void setIsSecondAddress(String isSecondAddress) {
		this.isSecondAddress = isSecondAddress;
	}

	public String getIsParentCopanySecondName() {
		return isParentCopanySecondName;
	}

	public void setIsParentCopanySecondName(String isParentCopanySecondName) {
		this.isParentCopanySecondName = isParentCopanySecondName;
	}

	public String getIsParentCompanySecondGlobalName() {
		return isParentCompanySecondGlobalName;
	}

	public void setIsParentCompanySecondGlobalName(String isParentCompanySecondGlobalName) {
		this.isParentCompanySecondGlobalName = isParentCompanySecondGlobalName;
	}

	
}
