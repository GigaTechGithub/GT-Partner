package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc6;
import com.gt.models.FinDoc7;
import com.gt.repo.FinDoc6Repository;
import com.gt.repo.FinDoc7Repository;

@Service
@Resource(name="FinDoc7ServiceImpl")
public class FinDoc7ServiceImpl implements FinDoc7Service{
	@Autowired
	FinDoc7Repository finDoc7Repository;

	@Override
	public String saveFinDoc7(FinDoc7 incorporation) {
		try {
			finDoc7Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc7(long id) {
		try {
			finDoc7Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc7> findBydiligenceId(int dilId) {
		List<FinDoc7> finDoc7List = finDoc7Repository.findBydiligenceId(dilId);
		return finDoc7List;
	}
	
	@Override
	public FinDoc7 findById(long id) {
		FinDoc7 finDoc7 = finDoc7Repository.getById(id);
		return finDoc7;
	}
	
}