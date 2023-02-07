package com.gt.services;

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
}
