package com.gt.services;

import com.gt.models.IncorporationDoc;

public interface IncorporationDocService {
	String saveIncorporationDoc(IncorporationDoc incorporation);
	String deleteIncorporationDoc(long id);
}
