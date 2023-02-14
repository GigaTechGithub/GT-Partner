package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc3;

public interface FinDoc3Service {
	String saveFinDoc3(FinDoc3 incorporation);
	String deleteFinDoc3(long id);
	List<FinDoc3> findBydiligenceId(int dilId);
}