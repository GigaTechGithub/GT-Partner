package com.gt.services;

import java.util.List;

import com.gt.models.Diligence;

public interface DiligenceService {
	String saveDiligence(Diligence diligence);
	List<Diligence> findByid(long id);
	List<Diligence> findBystatus(int status);
	List<Diligence> findAll();
	List<Diligence> findByStatusAndProfileStatus(int status, int profileStatus);
}
