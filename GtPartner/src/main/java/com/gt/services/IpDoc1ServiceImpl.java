package com.gt.services;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gt.models.IpDoc1;
import com.gt.repo.IpDoc1Repository;


@Service
@Resource(name="IpDoc1ServiceImpl")
public class IpDoc1ServiceImpl implements IpDoc1Service{
	@Autowired
	IpDoc1Repository ipDoc1Repository;

	@Override
	public String saveIpDoc1(IpDoc1 ipDoc1) {
		try {
			ipDoc1Repository.save(ipDoc1);
			String rowId = ipDoc1.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public String deleteIpDoc1(long id) {
		try {
			ipDoc1Repository.deleteById(id);
			return "Success";
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}

}