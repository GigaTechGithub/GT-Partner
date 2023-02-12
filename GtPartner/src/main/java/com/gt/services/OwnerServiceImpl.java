package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.Owner;
import com.gt.repo.OwnerRepository;

@Service
@Resource(name="OwnerServiceImpl")
public class OwnerServiceImpl implements OwnerService{
	@Autowired
	OwnerRepository ownerRepository;
	
	@Override
	public String saveOwner(Owner owner) {
		try {
			ownerRepository.save(owner);
			String rowId = owner.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
		
	}
	
	@Override
	public String deleteOwner(long id) {
		try {
			ownerRepository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public List<Owner> findBydiligenceId(int dilId) {
		List<Owner> ownerList = ownerRepository.findBydiligenceId(dilId);
		return ownerList;
		
	}

}
