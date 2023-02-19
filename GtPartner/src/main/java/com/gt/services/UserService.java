package com.gt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gt.models.Users;


public interface UserService {
	Users findByid(long id);
	String saveUser(Users user);
	List<Users> usersList();
	void deleteUser(long id);
	Users findByusername(String userName);
	List<Users> findAll();
}
