package com.shopping.daoHibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.shopping.model.ItemCart;
import com.shopping.util.HibernateUtil;

public class ItemCartDAOHibernate {
	SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
	public void insert(ItemCart itemcart) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(itemcart);
		trans.commit();
		session.close();
	}
	
	public void update(ItemCart itemcart) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(itemcart);
		trans.commit();
		session.close();
	}
	
	public void delete(ItemCart itemcart) {
		
		Session session = sessionfactory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(itemcart);
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemCart> list(){
		Criteria criteria=null;
		try {
			Session session = sessionfactory.openSession();
			
			criteria = session.createCriteria(ItemCart.class);
			criteria.addOrder(Order.asc("id"));
		}catch(HibernateException e) {
			System.out.println(e);
		}
		
		
		return criteria.list();
	}
	
	public ItemCart find(int id){
		
		ItemCart itemCart=null;
		Session session=sessionfactory.openSession();

		itemCart=(ItemCart) session.get(ItemCart.class, id);

		
		return itemCart;
	}
	
}
