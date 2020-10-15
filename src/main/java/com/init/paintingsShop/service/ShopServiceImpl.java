package com.init.paintingsShop.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.paintingsShop.dao.IPictureDAO;
import com.init.paintingsShop.dao.IShopDAO;
import com.init.paintingsShop.dto.Picture;
import com.init.paintingsShop.dto.Shop;

@Service
public class ShopServiceImpl implements IShopService {
	
	@Autowired
	IShopDAO ishopDAO;

	
	@Override
	public Shop saveShop(Shop shop) {
		
		return ishopDAO.save(shop);
	}

	@Override
	public List<Shop> listShops() {
		
		return ishopDAO.findAll();
	}

}
