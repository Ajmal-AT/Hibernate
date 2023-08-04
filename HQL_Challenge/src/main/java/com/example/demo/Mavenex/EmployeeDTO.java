package com.example.demo.Mavenex;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_table")
public class EmployeeDTO {
	@Id
	 private int empno;
	 private String ename;
	 private int sal;
	 private String job;
	 private int deptno ;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public EmployeeDTO() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", job=" + job + ", deptno="
				+ deptno + "]";
	}
}
