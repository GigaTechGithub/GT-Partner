package com.gt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long>{

}
