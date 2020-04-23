package com.cg.payroll.beans;

public class Associate {
	private int associateID,yearlyTnvestmentUnder80C;
	private String firstName, lastName, department, designation,pancard,emailid;
//	private Salary salary;
//	private Bank bank;
	public Associate() {
		
	}
	public Associate(int yearlyTnvestmentUnder80C, String firstName, String lastName, String department,
			String designation, String pancard, String emailid) {
		super();
		this.yearlyTnvestmentUnder80C = yearlyTnvestmentUnder80C;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.pancard = pancard;
		this.emailid = emailid;
//		this.salary = salary;
//		this.bank = bank;
	}
	public int getAssociateID() {
		return associateID;
	}
	public void setAssociateID(int associateID) {
		this.associateID = associateID;
	}
	public int getYearlyTnvestmentUnder80C() {
		return yearlyTnvestmentUnder80C;
	}
	public void setYearlyTnvestmentUnder80C(int yearlyTnvestmentUnder80C) {
		this.yearlyTnvestmentUnder80C = yearlyTnvestmentUnder80C;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
//	public Salary getSalary() {
//		return salary;
//	}
//	public void setSalary(Salary salary) {
//		this.salary = salary;
//	}
//	public Bank getBank() {
//		return bank;
//	}
//	public void setBank(Bank bank) {
//		this.bank = bank;
//	}
	
}
