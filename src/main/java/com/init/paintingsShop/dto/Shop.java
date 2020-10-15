package com.init.paintingsShop.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
* Esta clase define el objeto shop
* @author: Francesc Nohales
* @version: 1.0
*/
@Entity
@Table(name="shop")

public class Shop {
	
	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", capacity=" + capacity + "]";
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	@Column(name="name")
	private String name;
	
	@Column(name="capacity")
	private Integer capacity;
	
	
	/**
	 * Constructor para la clase shop
	 * @param id
	 * @param name
	 * @param capacity
	 * */
	
	public Shop(Integer id, String name, Integer capacity) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}
	public Shop() {
	}
	
	
	// Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getId() {
		return id;
	}
	
	
}
