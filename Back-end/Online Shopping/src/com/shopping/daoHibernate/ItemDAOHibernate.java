package com.shopping.daoHibernate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.Item;
import com.shopping.util.HibernateUtil;
public class ItemDAOHibernate {
	SessionFactory sessionfactory;
	public ItemDAOHibernate() {
		// TODO Auto-generated constructor stub
		 sessionfactory = HibernateUtil.getSessionFactory();
		
	}
	
	public void insert(Item item) {
		try {
			Session session = sessionfactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(item);
			trans.commit();
			session.close();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	public void update(Item item) {
		try {
			Session session = sessionfactory.openSession();
			Transaction trans = session.beginTransaction();
			session.update(item);
			trans.commit();
			session.close();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	public void delete(Item item) {
		try {
			Session session = sessionfactory.openSession();
			Transaction trans = session.beginTransaction();
			session.delete(item);
			trans.commit();
			session.close();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> list(){
		Query query=null;
		try {
			Session session = sessionfactory.openSession();
			
			query = session.createQuery("from Item order by id");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return query.list();
		
	}
	
	public Item find(int id){
		
		Item item=null;
		try {
			Session session=sessionfactory.openSession();

			item=(Item) session.get(Item.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	

		
		return item;
	}
	public Double averagePriceByCategory(int idCategory) {
		
		
		Session session =sessionfactory.openSession();
		Query query = null;
		try {
			query =session.createQuery("select avg(price) from Item where category=:cate");
			query.setInteger("cate", idCategory);
		
		} catch (HibernateException e) {
			
			System.out.println(e);
		}
		
		return (double) query.uniqueResult();
		
	}
}
