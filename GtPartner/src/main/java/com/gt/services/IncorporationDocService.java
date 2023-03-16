package com.gt.services;

import java.util.List;

import com.gt.models.IncorporationDoc;

public interface IncorporationDocService {
	String saveIncorporationDoc(IncorporationDoc incorporation);
	String deleteIncorporationDoc(long id);
	List<IncorporationDoc> findBydiligenceId(int dilId);
	IncorporationDoc findById(long id);
}
