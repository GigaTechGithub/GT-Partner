package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc10;

public interface FinDoc10Service {
	String saveFinDoc10(FinDoc10 incorporation);
	String deleteFinDoc10(long id);
	List<FinDoc10> findBydiligenceId(int dilId);
	FinDoc10 findById(long id);
}
