package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc11;

public interface FinDoc11Service {
	String saveFinDoc11(FinDoc11 incorporation);
	String deleteFinDoc11(long id);
	List<FinDoc11> findBydiligenceId(int dilId);
}