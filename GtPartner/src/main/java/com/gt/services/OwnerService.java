package com.gt.services;

import com.gt.models.Owner;

public interface OwnerService {
	String saveOwner(Owner owner);
	String deleteOwner(long id);
}
