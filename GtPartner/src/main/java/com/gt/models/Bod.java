package com.gt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_bod")
public class Bod {
	
	 	@Id
	 	@Column(name="ID")
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	     
	    @Column(name="BOD_NAME", nullable=false, length=100)
	    private String bodName;
	     
	    @Column(name="BOD_SECOND_NAME", nullable=true, length=100)
	    private String BodSecondName;
	    
	    @Column(name="CREATED_BY", nullable=false, length=20)
	    private Integer createdBy;
	     
	    @Column(name="DILIGENCE_ID", nullable=false, length=20)
	    private Integer diligenceId;
	    
	    @Column(name="TILE", nullable=false, length=100)
	    private String tile;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getBodName() {
			return bodName;
		}

		public void setBodName(String bodName) {
			this.bodName = bodName;
		}

		public String getBodSecondName() {
			return BodSecondName;
		}

		public void setBodSecondName(String bodSecondName) {
			BodSecondName = bodSecondName;
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

		public String getTile() {
			return tile;
		}

		public void setTile(String tile) {
			this.tile = tile;
		}

		public Bod() {
			super();
		}

		
		public Bod(Long id, String bodName, String bodSecondName, Integer createdBy, Integer diligenceId, String tile) {
			super();
			this.id = id;
			this.bodName = bodName;
			BodSecondName = bodSecondName;
			this.createdBy = createdBy;
			this.diligenceId = diligenceId;
			this.tile = tile;
		}

		@Override
		public String toString() {
			return "Bod [id=" + id + ", bodName=" + bodName + ", BodSecondName=" + BodSecondName + ", createdBy="
					+ createdBy + ", diligenceId=" + diligenceId + ", tile=" + tile + "]";
		}

		
	    

}
