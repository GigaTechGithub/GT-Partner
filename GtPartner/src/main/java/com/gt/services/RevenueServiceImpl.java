package com.gt.services;

import java.util.List;

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

	@Override
	public List<Revenue> findBydiligenceId(int dilId) {
		List<Revenue> revList = revenueRepository.findBydiligenceId(dilId);
		
		if(revList.isEmpty()) {
			
			Revenue revenue = new Revenue();
			
			revenue.setId(null);
			revenue.setCreatedBy(null);
			revenue.setDiligenceId(null);
			revenue.setRevenue1(null);
			revenue.setRevenue2(null);
			revenue.setRevenue3(null);
			revenue.setRevenue4(null);
			
			revList.add(revenue);
		}
		
		return revList;
	}

}
