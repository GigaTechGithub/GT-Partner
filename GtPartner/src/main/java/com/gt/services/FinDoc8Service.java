package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc8;

public interface FinDoc8Service {
	String saveFinDoc8(FinDoc8 incorporation);
	String deleteFinDoc8(long id);
	List<FinDoc8> findBydiligenceId(int dilId);
	FinDoc8 findById(long id);
}
