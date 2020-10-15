package com.init.paintingsShop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.paintingsShop.dao.IPictureDAO;
import com.init.paintingsShop.dto.Picture;
import com.init.paintingsShop.dto.Shop;

@Service
public class PictureServiceImpl implements IPictureService {

	@Autowired
	IPictureDAO ipictureDAO;
	
	@Override
	public Picture savePicture(Picture picture) {
	
		return ipictureDAO.save(picture);
	}


	@Override
	public List<Picture> listPictures() {
		return ipictureDAO.findAll();
		}
	

	@Override
	public void deleteAllPictureByShop(Shop shop) {
	}
	
		@Override
	public List<Picture> listPicturesbyShop(List<Picture> shop_id){
		

				return null;
	}


		@Override
		public void deletePicture(Picture picture) {
			ipictureDAO.delete(picture);
			
		}
	


}
