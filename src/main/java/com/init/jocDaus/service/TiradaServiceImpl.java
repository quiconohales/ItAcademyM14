package com.init.jocDaus.service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.jocDaus.dao.ITiradaDAO;
import com.init.jocDaus.dto.Tirada;
import com.init.jocDaus.dto.Player;

@Service
public class TiradaServiceImpl implements ITiradaService {

	@Autowired
	ITiradaDAO itiradaDAO;
	
	@Override
	public Tirada saveTirada(Tirada tirada) {
	
		return itiradaDAO.save(tirada);
	}


	@Override
	public List<Tirada> listTirada() {
		return itiradaDAO.findAll();
		}

	@Override
	public void deleteTirada(Tirada tirada) {
		itiradaDAO.delete(tirada);
		
	}
	

//	@Override
//	public void deleteAllTiradaByPlayer(Player player) {
//	}
//	
//		@Override
//	public List<Tirada> listTiradabyPlayer(List<Tirada> player_id){
//		
//
//				return null;
//	}
//
//
//		@Override
//		public void deleteTirada(Tirada tirada) {
//			itiradaDAO.delete(tirada);
//			
//		}
//
//
//		@Override
//		public Tirada saveThrow(Tirada tirada) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//
//		@Override
//		public List<Tirada> listPictures() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//
//		@Override
//		public void deletePicture(Tirada tirada) {
//			// TODO Auto-generated method stub
//			
//		}
//
//
//		@Override
//		public List<Tirada> listPicturesbyShop(List<Tirada> player_id) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//
//		@Override
//		public void deleteAllPictureByShop(Player player) {
//			// TODO Auto-generated method stub
//			
//		}
	


}
