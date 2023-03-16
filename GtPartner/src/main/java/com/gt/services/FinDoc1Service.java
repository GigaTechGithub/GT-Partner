package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc1;

public interface FinDoc1Service {
	String saveFinDoc1(FinDoc1 incorporation);
	String deleteFinDoc1(long id);
	List<FinDoc1> findBydiligenceId(int dilId);
	FinDoc1 findById(long id);
}