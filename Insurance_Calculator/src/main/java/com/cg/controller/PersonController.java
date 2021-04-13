package com.cg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.entity.PersonEntity;
import com.cg.services.PersonIMP;
import com.cg.services.PersonServicesIMP;

@RestController
@RequestMapping("/Insurance_Calculator")
public class PersonController {

	@Autowired
	RestTemplate rest;

	@GetMapping("/checkEligibility")
	public List<String> getEligibility(PersonEntity p)
	{
		List<String> listofpolicy = new ArrayList<String>();
//		Object[] v= rest.getForObject("http://localhost/admins/admin/getAllPolicy",Object[].class);
//		System.out.println(v);
//		for(int i=0;i<v.length;i++)
//		{
//			System.out.println(v[i]);
//		}
		ParameterizedTypeReference<HashMap<Integer, String>> responseType = 
	               new ParameterizedTypeReference<HashMap<Integer, String>>() {};
	    
	    RequestEntity<Void> request = RequestEntity.get("http://localhost/admins/admin/getAllPolicy")
	                       .accept(MediaType.APPLICATION_JSON).build();
	    ResponseEntity<HashMap<Integer, String>> jsonDictionary = rest.exchange(request, responseType);
	    
	    System.out.println(jsonDictionary);
	    
		/*
		 * String msg=null; for (String string : listofpolicy) {
		 * 
		 * if(listofpolicy.equals("Term Insurance Without Disease")); { int
		 * a[]=imp.checkEligibilityWithoutDisease(p);
		 * msg="Term Insurance without Disease" +a[2]+" "+a[3]+" "+a[4]; }
		 * if(listofpolicy.equals("Term Insurance With Disease")) { int
		 * a[]=imp.checkEligibilityWithDisease(p);
		 * msg="Term Insurance with Disease"+a[2]+" "+a[3]+" "+a[4]; } }
		 * 
		 * List<String> list=new ArrayList<String>();
		 * list.add(p.getAdhar_No()+" is eligible for"+msg);
		 */
		
		
		return listofpolicy;
		
	}

	/*
	 * @PostMapping(value="/checkEligibility",consumes =
	 * MediaType.APPLICATION_JSON_VALUE) public List<String> insertEmp(@RequestBody
	 * PersonEntity e) {
	 * 
	 * 
	 * }
	 */

}
