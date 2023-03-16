package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc8;
import com.gt.models.FinDoc9;
import com.gt.repo.FinDoc8Repository;
import com.gt.repo.FinDoc9Repository;

@Service
@Resource(name="FinDoc9ServiceImpl")
public class FinDoc9ServiceImpl implements FinDoc9Service{
	@Autowired
	FinDoc9Repository finDoc9Repository;

	@Override
	public String saveFinDoc9(FinDoc9 incorporation) {
		try {
			finDoc9Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc9(long id) {
		try {
			finDoc9Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc9> findBydiligenceId(int dilId) {
		List<FinDoc9> finDoc9List = finDoc9Repository.findBydiligenceId(dilId);
		return finDoc9List;
	}
	
	@Override
	public FinDoc9 findById(long id) {
		FinDoc9 finDoc9 = finDoc9Repository.getById(id);
		return finDoc9;
	}
	
}