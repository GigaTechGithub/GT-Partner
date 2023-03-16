package com.gt.services;

import java.util.List;

import com.gt.models.Contracts;
import com.gt.models.IpDoc1;

public interface ContractsService {
	String saveContacts(Contracts contracts);
	String deleteContracts(long id);
	List<Contracts> findBydiligenceId(int dilId);
	Contracts findById(long id);
}
