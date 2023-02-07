package com.gt.services;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gt.models.It;
import com.gt.repo.ItRepository;

@Service
@Resource(name="ItServiceImpl")
public class ItServiceImpl implements ItService{
	@Autowired
	ItRepository itRepository;

	@Override
	public String saveIt(It it) {
		try {
			itRepository.save(it);
			String rowId = it.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

}

