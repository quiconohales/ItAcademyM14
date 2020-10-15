package com.init.paintingsShop.service;

import java.util.List;

import com.init.paintingsShop.dto.Picture;
import com.init.paintingsShop.dto.Shop;

public interface IPictureService {
	
	public Picture savePicture(Picture picture);
	public List<Picture> listPictures();
	public void deletePicture(Picture picture);
	public List<Picture> listPicturesbyShop(List<Picture> shop_id);
	public void deleteAllPictureByShop(Shop shop);
	
	

}
