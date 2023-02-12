package com.gt.services;

import java.util.List;

import com.gt.models.Contracts;

public interface ContractsService {
	String saveContacts(Contracts contracts);
	String deleteContracts(long id);
	List<Contracts> findBydiligenceId(int dilId);
}
