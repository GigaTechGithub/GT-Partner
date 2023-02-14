package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc7;

public interface FinDoc7Service {
	String saveFinDoc7(FinDoc7 incorporation);
	String deleteFinDoc7(long id);
	List<FinDoc7> findBydiligenceId(int dilId);
}