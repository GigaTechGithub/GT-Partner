package com.gt.services;

import java.util.List;

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

	@Override
	public List<Ip> findBydiligenceId(int dilId) {
		List<Ip> ipList = ipRepository.findBydiligenceId(dilId);
		
		if(ipList.isEmpty()) {
			
			Ip ip = new Ip();
			
			ip.setId(null);
			ip.setCreatedBy(null);
			ip.setDiligenceId(null);
			ip.setIp1(null);
			ip.setIp2(null);
			ip.setIp3(null);
			ip.setIp4(null);
			ip.setIp5(null);
			ip.setIp6(null);
			ip.setIp7(null);
			ip.setIp8(null);
			ip.setIp9(null);
			
			ipList.add(ip);
		}
		
		return ipList;
	}

}
