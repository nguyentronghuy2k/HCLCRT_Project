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
	SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
	public void insert(Item item) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(item);
		trans.commit();
		session.close();
	}
	
	public void update(Item item) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(item);
		trans.commit();
		session.close();
	}
	
	public void delete(Item item) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(item);
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> list(){
		
		
		Session session = sessionfactory.openSession();
		
		Query query = session.createQuery("from Item order by id");
		
		return query.list();
	}
	
	public Item find(int id){
		
		Item item=null;
		Session session=sessionfactory.openSession();

		item=(Item) session.get(Item.class, id);

		
		return item;
	}
	public Double averagePriceByCategory(int id_category) {
		
		
		Session session =sessionfactory.openSession();
		Query query = null;
		try {
			query =session.createQuery("select avg(price) from Item where category=:cate");
			query.setInteger("cate", id_category);
		
		} catch (HibernateException e) {
			
			System.out.println(e);
		}
		
		return (double) query.uniqueResult();
		
	}
}
