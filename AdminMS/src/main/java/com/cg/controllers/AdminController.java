package com.cg.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Policy;
import com.cg.services.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminServiceImpl adminSer;
	
	@PostMapping("/addPolicy")
	public void addPolicy(@RequestBody Policy p) {
		adminSer.addPolicy(p);
	}
	
	@GetMapping("/getAllPolicy")
	public Map<Integer,String> getAllPolicy(){
		return adminSer.getAllPolicy();
	}
	
	@PutMapping("/updatePolicy")
	public void updatePolicy(@RequestBody Policy p) {
		adminSer.updatePolicy(p);
	}
	
	@DeleteMapping("/removePolicy/{id}")
	public void removePolicy(@PathVariable Integer id) {
		adminSer.removePolicy(id);
	}
	
	@GetMapping("/getPolicyDetails")
	public List<Policy> getPolicyDetails(){
		return adminSer.getPolicyDetails();
	}
}
