package com.hibernateex;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {

	//private SessionFactory factory;
	
	

	
	/* Method to READ all the employees */
	public void listEmployees() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			List<Employee> employees = session.createQuery("FROM Employee").list();

			for (Employee item : employees) {
				System.out.print(item.getFirstName());
				System.out.print(item.getLastName());
				System.out.println(item.getSalary());
			}

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Employee getUserByID(int id) {
		Employee employee = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			String hql = "from Employee e where e.id = :id";
			employee = (Employee) session.createQuery(hql)
									.setInteger("id", id)
									.uniqueResult();
									

			System.out.print(employee.getFirstName() + " ");
			System.out.print(employee.getLastName() + " ");
			System.out.println(employee.getSalary());

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employee;
	}
	
	public boolean delete(Employee employee) {
		boolean result = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.delete(employee);
			tx.commit();

		} catch (HibernateException e) {
			result = false;
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	public boolean create(Employee employee) {
		boolean result = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.save(employee);
			tx.commit();

		} catch (HibernateException e) {
			result = false;
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public boolean update(Employee employee) {
		boolean result = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.update(employee);
			tx.commit();

		} catch (HibernateException e) {
			result = false;
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	
	

}
