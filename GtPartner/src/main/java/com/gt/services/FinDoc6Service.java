package com.gt.services;

import java.util.List;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc6;

public interface FinDoc6Service {
	String saveFinDoc6(FinDoc6 incorporation);
	String deleteFinDoc6(long id);
	List<FinDoc6> findBydiligenceId(int dilId);
	FinDoc6 findById(long id);
}
