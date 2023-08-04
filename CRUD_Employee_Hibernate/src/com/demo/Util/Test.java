package com.demo.Util;

import java.util.Iterator;
import java.util.List;

import com.demo.DAO.EmpDAO;
import com.demo.DTO.EmpDTO;

public class Test {

	public static void main(String[] args) {
		EmpDTO emp = new EmpDTO();
//		emp.setEname("Dhanish");
//		emp.setJob("Sr.Developer");
//		emp.setSal(74000);
//		emp.setDeptno(40);
//		
		EmpDAO dao = new EmpDAO();
//		dao.insert(emp);
		//dao.viewEmployees();
		//dao.delete(45);
		//dao.update(25000, 35000);
		dao.getEmployeesByDeptNo(30);
	}

}
