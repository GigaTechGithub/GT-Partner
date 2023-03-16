package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc2;
import com.gt.models.FinDoc3;
import com.gt.repo.FinDoc2Repository;
import com.gt.repo.FinDoc3Repository;

@Service
@Resource(name="FinDoc3ServiceImpl")
public class FinDoc3ServiceImpl implements FinDoc3Service{
	@Autowired
	FinDoc3Repository finDoc3Repository;

	@Override
	public String saveFinDoc3(FinDoc3 incorporation) {
		try {
			finDoc3Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc3(long id) {
		try {
			finDoc3Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc3> findBydiligenceId(int dilId) {
		List<FinDoc3> finDoc3List = finDoc3Repository.findBydiligenceId(dilId);
		return finDoc3List;
	}

	@Override
	public FinDoc3 findById(long id) {
		FinDoc3 finDoc3 = finDoc3Repository.getById(id);
		return finDoc3;
	}
}