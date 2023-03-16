package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc10;
import com.gt.models.FinDoc11;
import com.gt.repo.FinDoc10Repository;
import com.gt.repo.FinDoc11Repository;

@Service
@Resource(name="FinDoc11ServiceImpl")
public class FinDoc11ServiceImpl implements FinDoc11Service{
	@Autowired
	FinDoc11Repository finDoc11Repository;

	@Override
	public String saveFinDoc11(FinDoc11 incorporation) {
		try {
			finDoc11Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc11(long id) {
		try {
			finDoc11Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc11> findBydiligenceId(int dilId) {
		List<FinDoc11> finDoc11List = finDoc11Repository.findBydiligenceId(dilId);
		return finDoc11List;
	}
	
	@Override
	public FinDoc11 findById(long id) {
		FinDoc11 finDoc11 = finDoc11Repository.getById(id);
		return finDoc11;
	}
}