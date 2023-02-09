package com.gt.services;

import java.util.List;

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

	@Override
	public List<Technology> findBydiligenceId(int dilId) {
		List<Technology> techList = technologyRepository.findBydiligenceId(dilId);
		
		if(techList.isEmpty()) {
			
			Technology technology = new Technology();
			
			technology.setId(null);
			technology.setCreatedBy(null);
			technology.setDiligenceId(null);
			technology.setTech1(null);
			technology.setTech2(null);
			technology.setTech3(null);
			technology.setTech4(null);
			technology.setTech5(null);
			technology.setTech6(null);
			technology.setTech7(null);
			technology.setTech8(null);
			technology.setTech9(null);
			technology.setTech10(null);
			technology.setTech11(null);
			technology.setTech12(null);
			technology.setTech13(null);
			technology.setTech14(null);
			technology.setTech15(null);
			technology.setTech16(null);
			technology.setTech17(null);
			technology.setTech18(null);
			technology.setTech19(null);
			technology.setTech20(null);
			technology.setTech21(null);
			technology.setTech22(null);
			technology.setTech23(null);
			technology.setTech24(null);
			technology.setTech25(null);
			technology.setTech26(null);
			technology.setTech27(null);
			technology.setTech28(null);
			technology.setTech29(null);
			technology.setTech30(null);
			technology.setTech31(null);
			technology.setTech32(null);
			technology.setTech33(null);
			technology.setTech34(null);
			technology.setTech35(null);
			technology.setTech36(null);
			technology.setTech37(null);
			technology.setTech38(null);
			technology.setTech39(null);
			technology.setTech40(null);
			technology.setTech41(null);
			technology.setTech42(null);
			
			techList.add(technology);
		}
		
		return techList;
	}

}