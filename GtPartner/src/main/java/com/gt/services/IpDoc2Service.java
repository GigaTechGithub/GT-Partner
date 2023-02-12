package com.gt.services;

import java.util.List;

import com.gt.models.IpDoc2;

public interface IpDoc2Service {
	String saveIpDoc2(IpDoc2 ipDoc2);
	String deleteIpDoc2(long id);
	List<IpDoc2> findBydiligenceId(int dilId);
}
