package com.gt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity
@Table(name="T_incorporation_doc")
public class IncorporationDoc {
	
	@Id
 	@Column(name="ID")
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="CREATED_BY")
    private Integer createdBy;
    
    @Column(name="DILIGENCE_ID")
    private Integer diligenceId;
    
    @Column(name="FILE_NAME")
    private String fileName;
    
    @Column(name="FILE_PATH")
    private String filePath;

	public IncorporationDoc() {
		super();
	}

	public IncorporationDoc(Long id, Integer createdBy, Integer diligenceId, String fileName, String filePath) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.diligenceId = diligenceId;
		this.fileName = fileName;
		this.filePath = filePath;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "IncorporationDoc [id=" + id + ", createdBy=" + createdBy + ", diligenceId=" + diligenceId
				+ ", fileName=" + fileName + ", filePath=" + filePath + "]";
	}
    
    
    

}
