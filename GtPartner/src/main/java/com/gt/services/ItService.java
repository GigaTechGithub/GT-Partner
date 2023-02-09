package com.gt.services;

import java.util.List;

import com.gt.models.It;

public interface ItService {
	String saveIt(It it);
	List<It> findBydiligenceId(int dilId);
}
