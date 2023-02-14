package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc6;
import com.gt.models.FinDoc8;
import com.gt.repo.FinDoc6Repository;
import com.gt.repo.FinDoc8Repository;

@Service
@Resource(name="FinDoc8ServiceImpl")
public class FinDoc8ServiceImpl implements FinDoc8Service{
	@Autowired
	FinDoc8Repository finDoc8Repository;

	@Override
	public String saveFinDoc8(FinDoc8 incorporation) {
		try {
			finDoc8Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc8(long id) {
		try {
			finDoc8Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc8> findBydiligenceId(int dilId) {
		List<FinDoc8> finDoc8List = finDoc8Repository.findBydiligenceId(dilId);
		return finDoc8List;
	}
	
}