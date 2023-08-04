package com.demo.DAO;

import java.util.Iterator;
import java.util.List;

import org.antlr.gunit.gUnitParser.input_return;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.DTO.EmpDTO;
import com.demo.Util.HibernateUtil;

public class EmpDAO {
	public void insert(EmpDTO dto) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
		try {
			s.save(dto);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			s.close();
		}
	}
	
	public void getEmployeesByDeptNo(int deptNo) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
	    Query query = s.createQuery("FROM EmpDTO d where d.deptno='"+deptNo+"'");
	    List<EmpDTO> employees = query.list();
	    Iterator<EmpDTO> itr = employees.iterator();
        while(itr.hasNext()) {
        	EmpDTO obj = itr.next();
        	System.out.println();
        	System.out.println(obj);
        }
	    s.close();
	}
	public void viewEmployees() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();

        // Use HQL query based on the entity, not the table name directly
        Query query = s.createQuery("FROM EmpDTO");
        List<EmpDTO> employees = query.list();
        Iterator<EmpDTO> itr = employees.iterator();
        while(itr.hasNext()) {
        	EmpDTO obj = itr.next();
        	System.out.println();
        	System.out.println(obj);
        }
//        System.out.println(employees);
        tx.commit();
        s.close();
    }
	
	
	public void delete(int deptno) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
		int i=0;
		try {
			Query qry = s.createQuery("delete from EmpDTO d where d.deptno='"+deptno+"'");
			i=qry.executeUpdate();
			if(i>0) {
				System.out.println("Deletion successfully");
			}else {
				System.out.println("Deletion failure");
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			s.close();
		}
	}
	
	public void update(int oldsal,int newsal) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
		int i=0;
		try {
			Query qry = s.createQuery("update EmpDTO d set d.sal='"+newsal+"' where d.sal='"+oldsal+"'");
			i = qry.executeUpdate();
			if(i>0) {
				System.out.println("Updation successfully");
			}else {
				System.out.println("Updation failure");
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			s.close();
		}
	}
	
	
}
