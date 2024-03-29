package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.IncorporationDoc;
import com.gt.repo.IncorporationDocRepository;


@Service
@Resource(name="IncorporationDocServiceImpl")
public class IncorporationDocServiceImpl implements IncorporationDocService{
	@Autowired
	IncorporationDocRepository incorporationDocRepository;

	@Override
	public String saveIncorporationDoc(IncorporationDoc incorporation) {
		try {
			incorporationDocRepository.save(incorporation);
			String rowId = incorporation.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteIncorporationDoc(long id) {
		try {
			incorporationDocRepository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<IncorporationDoc> findBydiligenceId(int dilId) {
		List<IncorporationDoc> incorporationDocList = incorporationDocRepository.findBydiligenceId(dilId);
		return incorporationDocList;
	}

	@Override
	public IncorporationDoc findById(long id) {
		IncorporationDoc incorporationDoc = incorporationDocRepository.getById(id);
		return incorporationDoc;
	}

}
