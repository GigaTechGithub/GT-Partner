package com.gt.services;

import java.util.List;

import com.gt.models.Bod;

public interface BodService {
	String saveBod(Bod bod);
	String deleteBod(long id);
	List<Bod> findBydiligenceId(int dilId);
}
