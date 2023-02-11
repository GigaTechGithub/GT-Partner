package com.gt.services;

import com.gt.models.Contracts;

public interface ContractsService {
	String saveContacts(Contracts contracts);
	String deleteContracts(long id);
}
