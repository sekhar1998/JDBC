package com.cg.payroll.dao;

import java.util.List;

import com.cg.payroll.beans.Associate;

public interface AssociateDAO {
	
	Associate save(Associate associate);
	boolean update(Associate associate);
	Associate findOne(int associateId);
	List<Associate>	findALL();
}
