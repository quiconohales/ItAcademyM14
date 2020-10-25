package com.init.jocDaus.dto;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.OneToMany;


/**
* Esta clase define el objeto Player
* @author: Francesc Nohales
* @version: 1.0
*/
@Entity
@Table(name="player")

public class Player {
	

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	@Column(name="name")
	private String name;
	
	@Column(name="success")
	private Double success;
	
	@Column(name = "registDate", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registDate;
	
	// Entities relationship
	@OneToMany(mappedBy="player")
	@JsonIgnore 
	private List<Tirada> tirada;

	/**
	 * Constructor para la clase Player
	 * @param id
	 * @param name
	 * */
	

	
	public Player() {
	}


	// Getters & Setters
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Player(Integer id, String name, Double success, Date registDate, List<Tirada> tirada) {
		super();
		this.id = id;
		this.name = name;
		this.success = success;
		this.registDate = registDate;
	
	}


	public Double getSuccess() {
		return success;
	}


	public void setSuccess(Double success) {
		this.success = success;
	}


	public Date getRegistDate() {
		return registDate;
	}


	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}


	public List<Tirada> getTirada() {
		return tirada;
	}


	public void setTirada(List<Tirada> tirada) {
		this.tirada = tirada;
	}
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", success=" + success + ", registDate=" + registDate
				;
	}


	
}
