package com.example.demo.Mavenex;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
//        EmployeeDTO dto = em.find(EmployeeDTO.class, 2);
//        System.out.println(dto);
        
//        Query qry = em.createQuery("FROM EmployeeDTO d WHERE d.ename LIKE 'A%'");
//        List<EmployeeDTO> l1 = qry.getResultList();
//        Iterator itr = l1.iterator();
//        while(itr.hasNext()) {
//        	EmployeeDTO data = (EmployeeDTO) itr.next();
//        	System.out.println();
//        	System.out.println(data);
//        }
//        System.out.println(l1);
        
//          Query qry = em.createQuery("FROM EmployeeDTO d WHERE d.sal between 50000 AND 70000");
//          List<EmployeeDTO> l1 = qry.getResultList();
//          Iterator itr = l1.iterator();
//          while(itr.hasNext()) {
//          	EmployeeDTO data = (EmployeeDTO) itr.next();
//          	System.out.println();
//          	System.out.println(data);
//          }
        
//          Query qry = em.createQuery("select min(d.sal) as second_minimum_salary from EmployeeDTO d where d.sal > (select min(d.sal) from EmployeeDTO d)");
//          List<EmployeeDTO> li = qry.getResultList();
//          System.out.println("2nd Minimum Salary is "+li);
        
//          Query qry = em.createQuery("select max(d.sal) as second_maximum_salary from EmployeeDTO d where d.sal < (select max(d.sal) from EmployeeDTO d)");
//          List<EmployeeDTO> li = qry.getResultList();
//          System.out.println("2nd Maximum Salary is "+li);
        
//        
        try {
        	tx.begin();
        	int ssal = (int) em.createQuery("SELECT d.sal FROM EmployeeDTO d GROUP BY d.sal HAVING COUNT(*) > 1").getSingleResult();
            List qry = em.createQuery("SELECT d.empno, d.sal FROM EmployeeDTO d WHERE d.sal='"+ssal+"'").getResultList();
            Iterator itr = qry.iterator();
            while(itr.hasNext()) {
            	Object[] obj = (Object[]) itr.next();
            	System.out.println(String.valueOf(obj[0]));
            	System.out.println(String.valueOf(obj[1]));
            	System.out.println();
            }
//            System.out.println(qry);
            int i = em.createQuery("update EmployeeDTO d set d.sal=25000 where d.sal='"+ssal+"'").executeUpdate();
//            System.out.println(i);
            if(i>0) {
            	System.out.println("Updation successfully");
            } else {
            	System.out.println("Updation failure");
            }
            tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
        
    }
}
