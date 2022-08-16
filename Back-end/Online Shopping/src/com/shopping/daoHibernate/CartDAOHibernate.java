package com.shopping.daoHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.Cart;
import com.shopping.util.HibernateUtil;

public class CartDAOHibernate {
	SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
	public void insert(Cart cart) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(cart);
		trans.commit();
		session.close();
	}
	
	public void update(Cart cart) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(cart);
		trans.commit();
		session.close();
	}
	
	public void delete(Cart cart) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(cart);
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cart> list(){
		
		
		Session session = sessionfactory.openSession();
		
		Query query = session.createQuery("from Cart order by id");
		
		return query.list();
	}
	
	public Cart find(int id){
		
		Cart cart=null;
		Session session=sessionfactory.openSession();

		cart=(Cart) session.get(Cart.class, id);

		
		return cart;
	}
}
