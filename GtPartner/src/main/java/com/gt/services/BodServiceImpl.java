package com.gt.services;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.Bod;
import com.gt.repo.BodRepository;

@Service
@Resource(name="BodServiceImpl")
public class BodServiceImpl implements BodService{
	@Autowired 
	BodRepository bodRepository;
	
	@Override
	public String saveBod(Bod bod) {
		try {
			bodRepository.save(bod);
			String rowId = bod.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
		
	}
	
	@Override
	public String deleteBod(long id) {
		try {
			bodRepository.deleteById(id);
			return "Success";
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}
}
