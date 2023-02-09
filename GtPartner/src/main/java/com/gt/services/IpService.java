package com.gt.services;

import java.util.List;

import com.gt.models.Ip;

public interface IpService {
	String saveIp(Ip ip);
	List<Ip> findBydiligenceId(int dilId);
}
