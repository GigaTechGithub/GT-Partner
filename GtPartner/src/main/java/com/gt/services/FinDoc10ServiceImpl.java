package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc10;
import com.gt.models.FinDoc9;
import com.gt.repo.FinDoc10Repository;
import com.gt.repo.FinDoc9Repository;

@Service
@Resource(name="FinDoc10ServiceImpl")
public class FinDoc10ServiceImpl implements FinDoc10Service{
	@Autowired
	FinDoc10Repository finDoc10Repository;

	@Override
	public String saveFinDoc10(FinDoc10 incorporation) {
		try {
			finDoc10Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc10(long id) {
		try {
			finDoc10Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc10> findBydiligenceId(int dilId) {
		List<FinDoc10> finDoc10List = finDoc10Repository.findBydiligenceId(dilId);
		return finDoc10List;
	}
	
}