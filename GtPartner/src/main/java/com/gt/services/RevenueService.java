package com.gt.services;

import java.util.List;

import com.gt.models.Revenue;

public interface RevenueService {
	String saveRevenue(Revenue revenue);
	List<Revenue> findBydiligenceId(int dilId);
}
