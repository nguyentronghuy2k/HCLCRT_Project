package com.shopping.model;

import java.util.Date;

public class Item {
	private Long id;
	private String name;
	private Long price;
	private Integer saled;
	private String describe;
	private String img;
	private Date releaseDate;
	private Long idCategory;
	private Long idProducer;
	private Long idShop;
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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Integer getSaled() {
		return saled;
	}
	public void setSaled(Integer saled) {
		this.saled = saled;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public Long getIdProducer() {
		return idProducer;
	}
	public void setIdProducer(Long idProducer) {
		this.idProducer = idProducer;
	}
	public Long getIdShop() {
		return idShop;
	}
	public void setIdShop(Long idShop) {
		this.idShop = idShop;
	}
	public Item() {
		
	}
	
	public Item(Long id, String name, Long price, Integer saled, String describe, String img, Date releaseDate,
			Long idCategory, Long idProducer, Long idShop) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.saled = saled;
		this.describe = describe;
		this.img = img;
		this.releaseDate = releaseDate;
		this.idCategory = idCategory;
		this.idProducer = idProducer;
		this.idShop = idShop;
	}
	
	
}
