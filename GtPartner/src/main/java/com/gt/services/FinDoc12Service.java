package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc12;

public interface FinDoc12Service {
	String saveFinDoc12(FinDoc12 incorporation);
	String deleteFinDoc12(long id);
	List<FinDoc12> findBydiligenceId(int dilId);
}
