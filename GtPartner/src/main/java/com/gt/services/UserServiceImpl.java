package com.gt.services;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.Users;
import com.gt.repo.UserRepository;

@Service
@Resource(name="UserServiceImpl")
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Users> usersList() {
		List<Users> usersList = userRepository.findAll();
		
		if(usersList.size() > 0) {
            return usersList;
        } else {
            return new ArrayList<Users>();
        }
	}

	@Override
	public Users findByusername(String userName) {
		Users usersList = userRepository.findByusername(userName);
		
		if(usersList  != null) {
            return usersList;
        } else {
            return null;
        }
	}

	@Override
	public String saveUser(Users user) {
		try {
			userRepository.save(user);
			String rowId = user.getId().toString();
			return rowId;
		}
		
		catch(Exception e) {
			return "Failed";
		}
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);		
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}
}
