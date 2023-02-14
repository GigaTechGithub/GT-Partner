package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc5;

public interface FinDoc5Service {
	String saveFinDoc5(FinDoc5 incorporation);
	String deleteFinDoc5(long id);
	List<FinDoc5> findBydiligenceId(int dilId);
}
