package com.shopping.daoHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.Shop;
import com.shopping.util.HibernateUtil;

public class ShopDAOHibernate {
	SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
	public void insert(Shop shop) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(shop);
		trans.commit();
		session.close();
	}
	
	public void update(Shop shop) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(shop);
		trans.commit();
		session.close();
	}
	
	public void delete(Shop shop) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(shop);
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Shop> list(){
		
		
		Session session = sessionfactory.openSession();
		
		Query query = session.createQuery("from shop order by id");
		
		return query.list();
	}
	
	public Shop find(int id){
		
		Shop shop=null;
		Session session=sessionfactory.openSession();

		shop=(Shop) session.get(Shop.class, id);

		
		return shop;
	}
}
