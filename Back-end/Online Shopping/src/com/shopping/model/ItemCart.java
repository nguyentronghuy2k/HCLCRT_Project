package com.shopping.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

//@NamedQueries(
//{
//@NamedQuery(name="getAll",query="from ItemCart")
//​}
//
//)

@Entity
@Table(name="itemCart")
public class ItemCart {
	@Id
	private Long id;
	@Column
	private String name;
	@Column
	private Long idItem;
	@Column
	private Long idCart;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId_item() {
		return idItem;
	}
	public void setId_item(Long id_item) {
		this.idItem = id_item;
	}
	public Long getId_cart() {
		return idCart;
	}
	public void setId_cart(Long id_cart) {
		this.idCart = id_cart;
	}
	
	public ItemCart(Long id, String name, Long id_item, Long id_cart) {
		this.id = id;
		this.name = name;
		this.idItem = id_item;
		this.idCart = id_cart;
	}
	
	
}
