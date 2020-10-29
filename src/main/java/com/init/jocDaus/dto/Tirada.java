package com.init.jocDaus.dto;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

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
* Esta clase define el objeto Tirada
* @author: Francesc Nohales
* @version: 1.0
*/
@Entity
@Table(name="tirada")

public class Tirada {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	@Column(name="dau1")
	private Integer dau1;
	
	@Column(name="dau2")
	private Integer dau2;
	
	@Column(name="win")
	private boolean win;
	
		
	@ManyToOne
	@JoinColumn(name = "fk_player")
	@JsonIgnore
	private Player player;
	
// 	quico	
//	@JsonIgnore
//	@JoinColumn(name="fk_player",nullable=false)
//	@ManyToOne(optional = false,cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
//	private Player player;

	
	// Contructores 
	public Tirada() {
		
		// Instanciar clase Random
		Random random = new Random();
		// entre 1 y 7, excluido el 7. 
		IntStream intStream = random.ints(2, 1, 7);
		// Iterador para ir obteniendo los números
		Iterator iterator = intStream.iterator();
		while (iterator.hasNext()) {
		dau1=(Integer)iterator.next();
		dau2=(Integer)iterator.next();
		}
		if (dau1+dau2==7) {
			win=true;
		}else {
			win=false;
		}
	}
		
	
	public Tirada(Integer id, Integer dau1, Integer dau2, boolean win,Player player) {
		super();
		this.id = id;
		this.dau1 = dau1;
		this.dau2 = dau2;
		this.win = win;
		this.player = player;
	}

	/**
	 * Constructor para la clase picture
	 * @param id
	 * @param name
	 * @param dau1
	 * @param dau2
	 * @param win
	 * @param player
	 */

	// Getters & setters 
	public Integer getId() {
		return id;
	}
	public Integer getDau1() {
		return dau1;
	}
	public void setDau1(Integer dau1) {
		this.dau1 = dau1;
	}
	public Integer getDau2() {
		return dau2;
	}
	public void setDau2(Integer dau2) {
		this.dau2 = dau2;
	}
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Tirada tirada() {
		return null;
	}

	@Override
	public String toString() {
		return "Dice Roll [id = " + id + ", dau1 = " + dau1 + ", dau 2 = " + dau2 + ",  win =" + win + ", player = " + player
				+ " ]";
	}

	

}
