package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc9;

public interface FinDoc9Service {
	String saveFinDoc9(FinDoc9 incorporation);
	String deleteFinDoc9(long id);
	List<FinDoc9> findBydiligenceId(int dilId);
	FinDoc9 findById(long id);
}
