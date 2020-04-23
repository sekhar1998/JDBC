package com.cg.payroll.util;

import java.util.HashMap;

import com.cg.payroll.beans.Associate;

public class PayrollUtil {
	public static int ASSOCIATE_ID_COUNTER=100;
	public static HashMap<Integer, Associate>associates= new HashMap<>();
	public static int getAssociate_ID_COUNTER() {
		return ++ASSOCIATE_ID_COUNTER;
	}
}
