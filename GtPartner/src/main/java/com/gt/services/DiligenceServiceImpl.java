package com.gt.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.Diligence;
import com.gt.repo.DiligenceRepository;

@Service
@Resource(name="DiligenceServiceImpl")
public class DiligenceServiceImpl implements DiligenceService{
	@Autowired
	DiligenceRepository diligenceRepository;
	
	@Override
	public String saveDiligence(Diligence diligence) {
		try {
			diligenceRepository.save(diligence);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}
	
	@Override
	public List<Diligence> findById(long id){
		return diligenceRepository.findById(id); 
	}
}
