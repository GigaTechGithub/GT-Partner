package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc4;

public interface FinDoc4Service {
	String saveFinDoc4(FinDoc4 incorporation);
	String deleteFinDoc4(long id);
	List<FinDoc4> findBydiligenceId(int dilId);
	FinDoc4 findById(long id);
}