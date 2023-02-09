package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.Legal;
import com.gt.repo.LegalRepository;


@Service
@Resource(name="LegalServiceImpl")
public class LegalServiceImpl implements LegalService{
	@Autowired
	LegalRepository legalRepository;
	
	@Override
	public String saveLegal(Legal legal) {
		try {
			legalRepository.save(legal);
			String rowId = legal.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
		
	}

	@Override
	public List<Legal> findBydiligenceId(int dilId) {
		List<Legal> legalList = legalRepository.findBydiligenceId(dilId);
		
		if(legalList.isEmpty()) {
			
			Legal legal = new Legal();
			
			legal.setId(null);
			legal.setCreatedBy(null);
			legal.setDiligenceId(null);
			legal.setLegal1(null);
			legal.setLegal2(null);
			legal.setLegal3(null);
			legal.setLegal4(null);
			legal.setLegal5(null);
			legal.setLegal6(null);
			legal.setLegal7(null);
			legal.setLegal8(null);
			legal.setLegal9(null);
			legal.setLegal10(null);
			legal.setLegal11(null);
			legal.setLegal12(null);
			legal.setLegal13(null);
			legal.setLegal14(null);
			legal.setLegal15(null);
			legal.setLegal16(null);
			
			legalList.add(legal);
		}
		
		return legalList;
	}
}
