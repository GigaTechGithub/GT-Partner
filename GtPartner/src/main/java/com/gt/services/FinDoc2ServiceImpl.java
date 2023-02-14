package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc2;
import com.gt.repo.FinDoc1Repository;
import com.gt.repo.FinDoc2Repository;

@Service
@Resource(name="FinDoc2ServiceImpl")
public class FinDoc2ServiceImpl implements FinDoc2Service{
	@Autowired
	FinDoc2Repository finDoc2Repository;

	@Override
	public String saveFinDoc2(FinDoc2 incorporation) {
		try {
			finDoc2Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc2(long id) {
		try {
			finDoc2Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc2> findBydiligenceId(int dilId) {
		List<FinDoc2> finDoc2List = finDoc2Repository.findBydiligenceId(dilId);
		return finDoc2List;
	}
	
}