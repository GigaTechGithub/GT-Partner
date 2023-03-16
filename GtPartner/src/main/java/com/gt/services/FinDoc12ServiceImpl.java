package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc11;
import com.gt.models.FinDoc12;
import com.gt.repo.FinDoc11Repository;
import com.gt.repo.FinDoc12Repository;

@Service
@Resource(name="FinDoc12ServiceImpl")
public class FinDoc12ServiceImpl implements FinDoc12Service{
	@Autowired
	FinDoc12Repository finDoc12Repository;

	@Override
	public String saveFinDoc12(FinDoc12 incorporation) {
		try {
			finDoc12Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc12(long id) {
		try {
			finDoc12Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc12> findBydiligenceId(int dilId) {
		List<FinDoc12> finDoc12List = finDoc12Repository.findBydiligenceId(dilId);
		return finDoc12List;
	}
	
	@Override
	public FinDoc12 findById(long id) {
		FinDoc12 finDoc12 = finDoc12Repository.getById(id);
		return finDoc12;
	}
}