package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc5;
import com.gt.models.FinDoc6;
import com.gt.repo.FinDoc5Repository;
import com.gt.repo.FinDoc6Repository;

@Service
@Resource(name="FinDoc6ServiceImpl")
public class FinDoc6ServiceImpl implements FinDoc6Service{
	@Autowired
	FinDoc6Repository finDoc6Repository;

	@Override
	public String saveFinDoc6(FinDoc6 incorporation) {
		try {
			finDoc6Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc6(long id) {
		try {
			finDoc6Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc6> findBydiligenceId(int dilId) {
		List<FinDoc6> finDoc6List = finDoc6Repository.findBydiligenceId(dilId);
		return finDoc6List;
	}
	
}