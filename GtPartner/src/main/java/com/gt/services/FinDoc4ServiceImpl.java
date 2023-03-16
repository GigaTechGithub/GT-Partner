package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc3;
import com.gt.models.FinDoc4;
import com.gt.repo.FinDoc3Repository;
import com.gt.repo.FinDoc4Repository;

@Service
@Resource(name="FinDoc4ServiceImpl")
public class FinDoc4ServiceImpl implements FinDoc4Service{
	@Autowired
	FinDoc4Repository finDoc4Repository;

	@Override
	public String saveFinDoc4(FinDoc4 incorporation) {
		try {
			finDoc4Repository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteFinDoc4(long id) {
		try {
			finDoc4Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<FinDoc4> findBydiligenceId(int dilId) {
		List<FinDoc4> finDoc4List = finDoc4Repository.findBydiligenceId(dilId);
		return finDoc4List;
	}
	
	@Override
	public FinDoc4 findById(long id) {
		FinDoc4 finDoc4 = finDoc4Repository.getById(id);
		return finDoc4;
	}
}