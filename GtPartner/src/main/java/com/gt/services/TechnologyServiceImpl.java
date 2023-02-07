package com.gt.services;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gt.models.Technology;
import com.gt.repo.TechnologyRepository;

@Service
@Resource(name="TechnologyServiceImpl")
public class TechnologyServiceImpl implements TechnologyService{
	@Autowired
	TechnologyRepository technologyRepository;

	@Override
	public String saveTechnology(Technology technology) {
		try {
			technologyRepository.save(technology);
			String rowId = technology.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

}