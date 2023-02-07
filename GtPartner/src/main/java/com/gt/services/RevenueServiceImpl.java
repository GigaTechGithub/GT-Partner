package com.gt.services;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.Revenue;
import com.gt.repo.RevenueRepository;

@Service
@Resource(name="RevenueServiceImpl")
public class RevenueServiceImpl implements RevenueService{
	@Autowired
	RevenueRepository revenueRepository;

	@Override
	public String saveRevenue(Revenue revenue) {
		try {
			revenueRepository.save(revenue);
			String rowId = revenue.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

}
