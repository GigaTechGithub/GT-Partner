package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc13;

public interface FinDoc13Service {
	String saveFinDoc13(FinDoc13 incorporation);
	String deleteFinDoc13(long id);
	List<FinDoc13> findBydiligenceId(int dilId);
	FinDoc13 findById(long id);
}