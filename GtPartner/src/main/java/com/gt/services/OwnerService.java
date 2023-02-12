package com.gt.services;

import java.util.List;

import com.gt.models.Owner;

public interface OwnerService {
	String saveOwner(Owner owner);
	String deleteOwner(long id);
	List<Owner> findBydiligenceId(int dilId);
}
