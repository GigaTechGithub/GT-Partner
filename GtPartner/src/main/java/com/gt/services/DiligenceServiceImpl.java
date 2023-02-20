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
			String diligenceId = diligence.getId().toString();
			return diligenceId;
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}
	
	@Override
	public List<Diligence> findByid(long id){
		return diligenceRepository.findByid(id); 
	}

	@Override
	public List<Diligence> findBystatus(int status) {
		return diligenceRepository.findBystatus(status);
	}

	@Override
	public List<Diligence> findAll() {
		return diligenceRepository.findAll();
	}

	@Override
	public List<Diligence> findByStatusAndProfileStatus(int status, int profileStatus) {
		return diligenceRepository.findByStatusAndProfileStatus(status, profileStatus);
	}

	public String deleteDiligence(long id) {
		 diligenceRepository.deleteById(id);
		 return "Success";
	}
	
}
