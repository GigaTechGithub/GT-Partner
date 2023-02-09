package com.gt.services;

import java.util.List;

import com.gt.models.Legal;

public interface LegalService {
	String saveLegal(Legal legal);
	List<Legal> findBydiligenceId(int dilId);
}
