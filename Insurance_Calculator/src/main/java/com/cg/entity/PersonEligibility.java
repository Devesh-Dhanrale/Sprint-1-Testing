package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_eligibility_details")
public class PersonEligibility {

	@Id
	private int adharNo;
	private String full_name;
	private int age;
	private double salary;
	private String policy_name;
	private double monthly_plan;
	private double halfYearly_plan;
	private double yearly_plan;

	public PersonEligibility() {
	}

	public PersonEligibility(int adharNo, String full_name, int age, double salary, String policy_name,
			double monthly_plan, double halfYearly_plan, double yearly_plan) {
		super();
		this.adharNo = adharNo;
		this.full_name = full_name;
		this.age = age;
		this.salary = salary;
		this.policy_name = policy_name;
		this.monthly_plan = monthly_plan;
		this.halfYearly_plan = halfYearly_plan;
		this.yearly_plan = yearly_plan;
	}

	public int getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(int adharNo) {
		this.adharNo = adharNo;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPolicy_name() {
		return policy_name;
	}

	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}

	public double getMonthly_plan() {
		return monthly_plan;
	}

	public void setMonthly_plan(double monthly_plan) {
		this.monthly_plan = monthly_plan;
	}

	public double getHalfYearly_plan() {
		return halfYearly_plan;
	}

	public void setHalfYearly_plan(double halfYearly_plan) {
		this.halfYearly_plan = halfYearly_plan;
	}

	public double getYearly_plan() {
		return yearly_plan;
	}

	public void setYearly_plan(double yearly_plan) {
		this.yearly_plan = yearly_plan;
	}

	@Override
	public String toString() {
		return "PersonEligibility [adharNo=" + adharNo + ", full_name=" + full_name + ", age=" + age + ", salary="
				+ salary + ", policy_name=" + policy_name + ", monthly_plan=" + monthly_plan + ", halfYearly_plan="
				+ halfYearly_plan + ", yearly_plan=" + yearly_plan + "]";
	}
	
}
