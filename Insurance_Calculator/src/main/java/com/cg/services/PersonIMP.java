package com.cg.services;

import java.util.List;

import com.cg.entity.PersonEntity;

public interface PersonIMP {
	
	
	public int[] checkEligibilityWithoutDisease(PersonEntity p);
	
	public int[] checkEligibilityWithDisease(PersonEntity p);
	
	public void addPerson(PersonEntity p);
	
	public void removePerson(int id);
	
	public List<PersonEntity> listAllPerson();
	
	
	
	

}
