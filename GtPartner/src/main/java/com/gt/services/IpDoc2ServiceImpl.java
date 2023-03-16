package com.gt.services;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.IpDoc1;
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

	@Override
	public List<IpDoc2> findBydiligenceId(int dilId) {
		List<IpDoc2> ipDoc2List = ipDoc2Repository.findBydiligenceId(dilId);
		return ipDoc2List;
	}

	@Override
	public IpDoc2 findById(long id) {
		IpDoc2 ipDoc2 = ipDoc2Repository.getById(id);
		return ipDoc2;
	}

}
