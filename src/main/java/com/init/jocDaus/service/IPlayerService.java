package com.init.jocDaus.service;

import java.util.ArrayList;
import java.util.List;

import com.init.jocDaus.dto.Player;



public interface IPlayerService {
	
	public Player savePlayer(Player player); // Guarda una  tienda
	
	public List<Player> listPlayer();// Lista todos las tiendas

	public Player updatePlayer(Player player);

	public Player playerXID(Integer id);

	public Player getPlayer(Integer id);



}

