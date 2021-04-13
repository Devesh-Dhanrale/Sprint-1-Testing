package com.cg.services;

import java.util.List;
import java.util.Map;

import com.cg.entities.Policy;

public interface AdminService {

	public void addPolicy(Policy p);
	
	public void updatePolicy(Policy p);
	
	public void removePolicy(Integer id);
	
	public List<Policy> getPolicyDetails();
	
	public Map<Integer,String> getAllPolicy();
}
