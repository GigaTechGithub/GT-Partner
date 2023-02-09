package com.gt.services;

import java.util.List;

import com.gt.models.Technology;

public interface TechnologyService {
	String saveTechnology(Technology technology);
	List<Technology> findBydiligenceId(int dilId);
}
