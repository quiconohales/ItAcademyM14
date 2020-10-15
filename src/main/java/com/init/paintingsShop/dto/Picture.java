package com.init.paintingsShop.dto;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
* Esta clase define el objeto picture
* @author: Francesc Nohales
* @version: 1.0
*/
@Entity
@Table(name="picture")

public class Picture {
	
	@Override
	public String toString() {
		return "Picture [id=" + id + ", name=" + name + ", painter=" + painter + ", price=" + price + ", registDate="
				+ registDate + ", shop=" + shop + "]";
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	@Column(name="name")
	private String name;
	
	@Column(name="painter")
	private String painter;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name = "date", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
     private Date registDate;
	
	@JsonIgnore
	@JoinColumn(name="fk_shop",nullable=false)
	@ManyToOne(optional = false,cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Shop shop;
	

	
	// Contructores 
	public Picture() {
	}
	/**
	 * Constructor para la clase picture
	 * @param id
	 * @param name
	 * @param painter
	 * @param price
	 * @param register date
	 * @param shop
	 */
	

	public Picture(Integer id, String name,String painter, Integer price, Date registDate, Shop shop) {
		super();
		this.id = id;
		this.name = name;
		this.painter = painter;
		this.price = price;
		this.registDate = registDate;
		this.shop = shop;
	}
	// Getters & setters 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPainter() {
		return painter;
	}
	public void setPainter(String painter) {
		this.painter = painter;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Integer getId() {
		return id;
	}




}