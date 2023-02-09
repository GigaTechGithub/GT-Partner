package com.gt.services;

import java.util.List;

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

	@Override
	public List<It> findBydiligenceId(int dilId) {
		List<It> itList = itRepository.findBydiligenceId(dilId);
		
		if(itList.isEmpty()) {
			
			It it = new It();
			
			it.setId(null);
			it.setCreatedBy(null);
			it.setDiligenceId(null);
			it.setIt1(null);
			it.setIt2(null);
			it.setIt3(null);
			it.setIt4(null);
			it.setIt5(null);
			it.setIt6(null);
			it.setIt7(null);
			it.setIt8(null);
			it.setIt9(null);
			it.setIt10(null);
			
			itList.add(it);
		}
		
		return itList;
	}

}

