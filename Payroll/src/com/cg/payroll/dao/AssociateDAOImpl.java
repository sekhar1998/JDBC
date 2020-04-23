package com.cg.payroll.dao;

import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.util.PayrollUtil;

public class AssociateDAOImpl implements AssociateDAO {

	
	public Associate save(Associate associate) {
		associate.setAssociateID(PayrollUtil.getAssociate_ID_COUNTER());
		PayrollUtil.associates.put(associate.getAssociateID(), associate);
		return associate;
	}

	@Override
	public boolean update(Associate associate) {
		PayrollUtil.associates.put(associate.getAssociateID(),associate);
		return true;
	}

	@Override
	public Associate findOne(int associateId) {
		return PayrollUtil.associates.get(associateId);
	}

	@Override
	public List<Associate> findALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
