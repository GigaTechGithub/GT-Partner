package com.gt.services;

import java.util.List;

import com.gt.models.Diligence;

public interface DiligenceService {
	String saveDiligence(Diligence diligence);
	List<Diligence> findById(long id);
}
