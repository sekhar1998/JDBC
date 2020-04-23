package com.cg.payroll.services;

import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.dao.AssociateDAO;
import com.cg.payroll.dao.AssociateDAOImpl;
import com.cg.payroll.exception.AssociateDetailsNotFound;

public class PayrollServicesImpl implements PayrollServices {

	private AssociateDAO associateDAO;
	
	public PayrollServicesImpl() {
		associateDAO=new AssociateDAOImpl();
	}
	
	
	
	@Override
	public int acceptAssociateDetails(Associate associate) {
		// TODO Auto-generated method stub
		associate = associateDAO.save(associate);
		return associate.getAssociateID(); 
	}

	@Override
	public int calculateNetSalary(int associateId) /*throws AssociateDetailsNotFound*/ {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Associate getAssociateDetails(int associateId) /*throws AssociateDetailsNotFound */{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Associate> getAllAssociatesDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
