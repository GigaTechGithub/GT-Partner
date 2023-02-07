package com.gt.services;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.Contracts;
import com.gt.repo.ContractsRepository;

@Service
@Resource(name="ContractsServiceImpl")
public class ContractsServiceImpl implements ContractsService{
	@Autowired
	ContractsRepository contractsRepository;
	
	@Override
	public String saveContacts(Contracts contracts) {
		try {
			contractsRepository.save(contracts);
			String rowId = contracts.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
		
	}

}