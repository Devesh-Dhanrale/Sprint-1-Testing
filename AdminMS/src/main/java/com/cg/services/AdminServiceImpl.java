package com.cg.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.AdminDao;
import com.cg.entities.Policy;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;
	
	@Override
	public void addPolicy(Policy p) {
		adminDao.saveAndFlush(p);
		System.out.println("Policy Added");
	}

	@Override
	public Map<Integer,String> getAllPolicy() {
		List<Policy> list = adminDao.findAll();
		Map<Integer,String> map = new TreeMap<>();
		
		for(Policy p: list) {
			Integer key = p.getPolicyId();
			String value = key+"-"+p.getPolicyName();
			map.put(key, value);
		}
		
		return map;
	}

	@Override
	public void updatePolicy(Policy p) {
		adminDao.saveAndFlush(p);
		System.out.println("Policy Updated");
	}

	@Override
	public void removePolicy(Integer id) {
		adminDao.deleteById(id);
		System.out.println("Policy Removed");
	}

	@Override
	public List<Policy> getPolicyDetails() {
		List<Policy> list = adminDao.findAll();
		return list;
	}

}
