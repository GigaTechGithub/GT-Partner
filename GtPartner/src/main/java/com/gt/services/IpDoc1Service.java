package com.gt.services;

import java.util.List;

import com.gt.models.IpDoc1;

public interface IpDoc1Service {
	String saveIpDoc1(IpDoc1 ipDoc1);
	String deleteIpDoc1(long id);
	List<IpDoc1> findBydiligenceId(int dilId);
	IpDoc1 findById(long id);
}
