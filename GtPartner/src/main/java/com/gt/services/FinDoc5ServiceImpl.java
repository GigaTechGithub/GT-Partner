package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc4;
import com.gt.models.FinDoc5;
import com.gt.repo.FinDoc4Repository;
import com.gt.repo.FinDoc5Repository;

@Service
@Resource(name="FinDoc5ServiceImpl")
public class FinDoc5ServiceImpl implements FinDoc5Service{
	@Autowired
	FinDoc5Repository finDoc5Repository;

	@Override
	public String saveFinDoc5(FinDoc5 incorporation) {
		try {
			finDoc5Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc5(long id) {
		try {
			finDoc5Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc5> findBydiligenceId(int dilId) {
		List<FinDoc5> finDoc5List = finDoc5Repository.findBydiligenceId(dilId);
		return finDoc5List;
	}
	
	@Override
	public FinDoc5 findById(long id) {
		FinDoc5 finDoc5 = finDoc5Repository.getById(id);
		return finDoc5;
	}
}