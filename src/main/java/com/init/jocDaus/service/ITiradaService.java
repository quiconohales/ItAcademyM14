package com.init.jocDaus.service;

import java.util.List;

import com.init.jocDaus.dto.Player;
import com.init.jocDaus.dto.Tirada;



public interface ITiradaService {
	
//	public Tirada saveThrow(Tirada tirada);
	public List<Tirada> listTirada();
	public void deleteTirada(Tirada tirada);
//	public List<Tirada> listPicturesbyShop(List<Tirada> player_id);
//	public void deleteAllPictureByShop(Player player);
//	
	public Tirada saveTirada(Tirada tirada);
	

}
