package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc11;
import com.gt.models.FinDoc13;
import com.gt.repo.FinDoc11Repository;
import com.gt.repo.FinDoc13Repository;

@Service
@Resource(name="FinDoc13ServiceImpl")
public class FinDoc13ServiceImpl implements FinDoc13Service{
	@Autowired
	FinDoc13Repository finDoc13Repository;

	@Override
	public String saveFinDoc13(FinDoc13 incorporation) {
		try {
			finDoc13Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc13(long id) {
		try {
			finDoc13Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc13> findBydiligenceId(int dilId) {
		List<FinDoc13> finDoc13List = finDoc13Repository.findBydiligenceId(dilId);
		return finDoc13List;
	}
	
}