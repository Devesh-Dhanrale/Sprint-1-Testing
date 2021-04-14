package com.cg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	PersonServicesIMP imp;

	@Autowired
	RestTemplate rest;

	@GetMapping("/checkEligibility/{adhar_No}/{name}/{age}/{salary}/{disease}/{gender}/{DOB}/{mobile_no}/{address}/{email_id}/{nationality}/{state}/{pincode}/{agent_ref_no}")
	public List<String> getEligibility(@PathVariable("adhar_No") int adhar, @PathVariable("name") String name,
			@PathVariable("age") int age, @PathVariable("salary") double salary,
			@PathVariable("disease") String disease, @PathVariable("gender") String gender,
			@PathVariable("DOB") String dob, @PathVariable("mobile_no") int mobile,
			@PathVariable("address") String address, @PathVariable("email_id") String email,
			@PathVariable("nationality") String nationality, @PathVariable("state") String state,
			@PathVariable("pincode") int pincode, @PathVariable("agent_ref_no") int agent, PersonEntity p) {

		p.setAdhar_No(adhar);
		p.setFull_name(name);
		p.setAge(age);
		p.setSalary(salary);
		p.setDisease(disease);
		p.setGender(gender);
		p.setDOB(dob);
		p.setMobile_no(mobile);
		p.setAddress(address);
		p.setEmail_id(email);
		p.setNationality(nationality);
		p.setState(state);
		p.setPincode(pincode);
		p.setAgent_ref_no(agent);

		System.out.println(p);

		List<String> listofpolicy = new ArrayList<String>();

		ParameterizedTypeReference<HashMap<Integer, String>> responseType = new ParameterizedTypeReference<HashMap<Integer, String>>() {
		};

		RequestEntity<Void> request = RequestEntity.get("http://localhost/admins/admin/getAllPolicy")
				.accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<HashMap<Integer, String>> jsonDictionary = rest.exchange(request, responseType);

		HashMap<Integer, String> map = jsonDictionary.getBody();

		for (Entry<Integer, String> entry : map.entrySet()) {
			listofpolicy.add(entry.getValue());
		}

		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();

		for (String str : listofpolicy) {
			String arr[] = str.split("-");
			String id = arr[0];
			String value = arr[1];
			list1.add(id); // has list of all policy ids
			list2.add(value); // has list of all policy names
		}

		System.out.println(list1);
		System.out.println(list2);

		String msg = null;
		int a[] = null;

		List<String> list = new ArrayList<String>();
		
		if (p.getDisease().equalsIgnoreCase("no") && list2.get(0).equals("Term Insurance Without Disease")) {
			a = imp.checkEligibilityWithoutDisease(p);
			msg = list2.get(0)+" " + a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " +a[4];
			
			if (a[0] == 0) {
				list.add("Adhar Number: "+p.getAdhar_No() + " is eligible for " + msg);
			} else if(a[0] == 1) {
				list.add("Adhar Number: "+p.getAdhar_No() + " is not eligible for the policies");
			}
		}

		if (p.getDisease().equalsIgnoreCase("yes") && list2.get(1).equals("Term Insurance With Disease")) {
			a = imp.checkEligibilityWithDisease(p);
			msg = list2.get(1)+" " + a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " +a[4];
			
			if (a[0] == 0) {
				list.add("Adhar Number: "+p.getAdhar_No() + " is eligible for " + msg);
			} else if(a[0] == 1){
				list.add("Adhar Number: "+p.getAdhar_No() + " is not eligible for the policies");
			}
		}

		return list;

	}

	@PostMapping("/addPerson")
	public void addPerson(PersonEntity p) {
		imp.addPerson(p);
	}

}
