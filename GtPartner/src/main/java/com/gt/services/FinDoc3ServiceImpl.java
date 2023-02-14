package com.gt.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gt.models.FinDoc1;
import com.gt.models.FinDoc3;

@Service
@Resource(name="FinDoc3ServiceImpl")
public class FinDoc3ServiceImpl implements FinDoc3Service{

	@Override
	public String saveFinDoc3(FinDoc3 incorporation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteFinDoc3(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FinDoc3> findBydiligenceId(int dilId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}