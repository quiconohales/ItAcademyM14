package com.init.paintingsShop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.paintingsShop.dto.Shop;



public interface IShopDAO extends JpaRepository <Shop,Integer>{

}
