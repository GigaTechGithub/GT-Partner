package com.gt.services;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gt.models.IpDoc2;
import com.gt.repo.IpDoc2Repository;

@Service
@Resource(name="IpDoc2ServiceImpl")
public class IpDoc2ServiceImpl implements IpDoc2Service{
	@Autowired
	IpDoc2Repository ipDoc2Repository;
	
	@Override
	public String saveIpDoc2(IpDoc2 ipDoc2) {
		try {
			ipDoc2Repository.save(ipDoc2);
			String rowId = ipDoc2.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteIpDoc2(long id) {
		try {
			ipDoc2Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

}
