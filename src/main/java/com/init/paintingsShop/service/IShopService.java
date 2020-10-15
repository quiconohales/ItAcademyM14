package com.init.paintingsShop.service;

import java.util.ArrayList;
import java.util.List;


import com.init.paintingsShop.dto.Picture;
import com.init.paintingsShop.dto.Shop;

public interface IShopService {
	
	public Shop saveShop(Shop shop); // Guarda una  tienda
	
	public List<Shop> listShops();// Lista todos las tiendas

}

