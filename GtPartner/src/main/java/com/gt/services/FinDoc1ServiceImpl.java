package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc1;
import com.gt.repo.FinDoc1Repository;

@Service
@Resource(name="FinDoc1ServiceImpl")
public class FinDoc1ServiceImpl implements FinDoc1Service{
	@Autowired
	FinDoc1Repository finDoc1Repository;

	@Override
	public String saveFinDoc1(FinDoc1 incorporation) {
		try {
			finDoc1Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc1(long id) {
		try {
			finDoc1Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc1> findBydiligenceId(int dilId) {
		List<FinDoc1> finDoc1List = finDoc1Repository.findBydiligenceId(dilId);
		return finDoc1List;
	}

}
