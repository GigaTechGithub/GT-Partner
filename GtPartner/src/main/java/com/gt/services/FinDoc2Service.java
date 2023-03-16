package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc2;

public interface FinDoc2Service {
	String saveFinDoc2(FinDoc2 incorporation);
	String deleteFinDoc2(long id);
	List<FinDoc2> findBydiligenceId(int dilId);
	FinDoc2 findById(long id);
}