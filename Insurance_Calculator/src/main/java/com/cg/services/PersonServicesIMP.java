package com.cg.services;
import java.text.SimpleDateFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.PersonDAO;
import com.cg.entity.PersonEntity;

@Service
public class PersonServicesIMP implements PersonIMP  {

	@Autowired
	PersonDAO dao;
	
	@Override
	public int[] checkEligibilityWithoutDisease(PersonEntity p) {
		
		int [] eligible_value=new int[5];
		
		double life_cover_amount=5000000;
		int premium_amount=400;
		
		if((p.getAge()<18 || p.getAge()>60) || p.getSalary()<300000){
			System.err.println("Person is Not Eligible");
			System.out.println("Please make sure the age is greater than 18 and less than 60 and salary should be greater than 3lac");
			eligible_value[0]= 1;//0 true and 1 false
			eligible_value[1]=p.getAdhar_No();
			eligible_value[2]=0000;
		}
		else
		{
			if(p.getAge()==18 && p.getSalary()>300000)
			{
				eligible_value[0]= 0;//0 true and 1 false
				eligible_value[1]=p.getAdhar_No();
				eligible_value[2]=premium_amount;
				eligible_value[3]=premium_amount*6;
				eligible_value[4]=premium_amount*12;
			}
			else {
				
				String dob=p.getDOB();
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				Date date = null;
				try {
					date = formatter.parse(dob);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Converting obtained Date object to LocalDate object
				Instant instant = date.toInstant();
				ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
				LocalDate givenDate = zone.toLocalDate();
				// Calculating the difference between given date to current date.
				Period period = Period.between(givenDate, LocalDate.now());
				int age=period.getYears();
				
				int rate=age-18;
				//int a=premium_amount/100*rate;
				//premium_amount=premium_amount+a;
				
				eligible_value[0]=0;//0 true and 1 false
				eligible_value[1]=p.getAdhar_No();
				int b=premium_amount/100*rate;
				eligible_value[2]=premium_amount+b;
				eligible_value[3]=(premium_amount+b)*6;
				eligible_value[4]=(premium_amount+b)*12;
			}
		}
		
		return eligible_value;
	}
	
	
	public int[] checkEligibilityWithDisease(PersonEntity p) {
		
		int [] eligible_value=new int[5];
		
		double life_cover_amount=5000000;
		int premium_amount=400;
		
		if((p.getAge()<18 || p.getAge()>60) || p.getSalary()<300000){
			System.err.println("Person is Not Eligible");
			System.out.println("Please make sure the age is greater than 18 and less than 60 and salary should be greater than 3lac");
			eligible_value[0]= 1;//0 true and 1 false
			eligible_value[1]=p.getAdhar_No();
			eligible_value[2]=0000;
		}
		else
		{
			if(p.getAge()==18 && p.getSalary()>300000)
			{
				eligible_value[0]= 0;//0 true and 1 false
				eligible_value[1]=p.getAdhar_No();
				eligible_value[2]=premium_amount;
				eligible_value[3]=premium_amount*6;
				eligible_value[4]=premium_amount*12;
			}
			else {
				
				String dob=p.getDOB();
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				Date date = null;
				try {
					date = formatter.parse(dob);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Converting obtained Date object to LocalDate object
				Instant instant = date.toInstant();
				ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
				LocalDate givenDate = zone.toLocalDate();
				// Calculating the difference between given date to current date.
				Period period = Period.between(givenDate, LocalDate.now());
				int age=period.getYears();
				
				int rate=age-18;
				//int a=premium_amount/100*rate;
				//premium_amount=premium_amount+a;
	
					eligible_value[0]=0;//0 true and 1 false
					eligible_value[1]=p.getAdhar_No();
					int b=(premium_amount/100*2)*rate;
					eligible_value[2]=premium_amount+b;
					eligible_value[3]=(premium_amount+b)*6;
					eligible_value[4]=(premium_amount+b)*12;
				
			
			}
		}

		
		
		return eligible_value;
	}

	@Override
	public void addPerson(PersonEntity p) {
		
		dao.saveAndFlush(p);
		System.out.println("Person Data added successfull in database");
	}

	@Override
	public void removePerson(int id) {
		
		dao.deleteById(id);
		System.out.println("Person Data with"+id+" Deleted successfull");
		
	}

	@Override
	public List<PersonEntity> listAllPerson() {
			return dao.findAll();
	}

}
