package com.cg.payroll.services;

import java.util.List;

import com.cg.payroll.beans.Associate;

public interface PayrollServices {
	int acceptAssociateDetails(Associate associate);
	int calculateNetSalary(int associateId);//throws AssociateDetailsNotFound;
	Associate getAssociateDetails(int associateId);//throws AssociateDetailsNotFound;
	List<Associate>	getAllAssociatesDetails();

}
