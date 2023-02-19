package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gt.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	Users findByusername(String userName);
	List<Users> findAll();
}
