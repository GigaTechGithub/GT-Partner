package com.gt.services;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gt.models.Ip;
import com.gt.repo.IpRepository;

@Service
@Resource(name="IpServiceImpl")
public class IpServiceImpl implements IpService{
	@Autowired
	IpRepository ipRepository;
	
	@Override
	public String saveIp(Ip ip) {
		try {
			ipRepository.save(ip);
			String rowId = ip.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

}
