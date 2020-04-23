package com.cg.payroll.main;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.Bank;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class MainClass {

	public static void main(String[] args) {
		//try	{
			PayrollServices payrollServices= new PayrollServicesImpl();
			Associate associate = new Associate(80000,"Ashish","Sharma","Software Associate","Con","HAEADF645","ashish.sharma@gmail.com");
			Salary sal = new Salary(50000,1000,1000);
			Bank bank = new Bank(452156542,"ICICI","ICICI51565");
			int associateId=payrollServices.acceptAssociateDetails(new Associate());
			
			System.out.println("Associate Id:- "+associateId);
			Associate associate1 = payrollServices.getAssociateDetails(associateId);
			System.out.println(sal.getBasicSalary()+" "+sal.getCompanyPf()+" "+sal.getEpf());
			System.out.println(bank.getAccountNumber()+" "+bank.getBankName()+" "+bank.getIfscCode());
			
			//} catch(AssociateDetailsNotFoundException e) {
			//	e.printStackTrace();
				
			//}
		

	}

} 
