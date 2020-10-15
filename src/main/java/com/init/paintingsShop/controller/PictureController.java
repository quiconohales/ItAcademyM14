package com.init.paintingsShop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.init.paintingsShop.dto.Shop;

import com.init.paintingsShop.dto.Picture;
import com.init.paintingsShop.service.PictureServiceImpl;
import javax.persistence.EntityManager;
@RestController
@RequestMapping("/picture")
public class PictureController {
	
	@Autowired
	PictureServiceImpl pictureServiceImpl;
	
	/**
     * Método que agrega un cuadro a una tienda introducido en la petición,
     * en caso que no se introduzca el nombre del pintor, asigna automaticamente
     * el valor "Anonymous"
     * @return nada
     * (POST/post/shops/{shopid})
     */
	
	@PostMapping ("/post/shops/{shopid}")//{shop_id}
	public Picture savePicture (@PathVariable (value="shopid")Shop shopid,@RequestBody Picture picture) {
		if (picture.getPainter()== null) {
				picture.setPainter("Anonymous");
		}
		picture.setShop(shopid);
		return pictureServiceImpl.savePicture(picture);
	}
	
	/**
     * Método que lista los cuadro de una tienda introducida en la petición
     * @return nada
     * (GET /shops/{ID}/pictures).
     */
	@GetMapping("/get/shops/{id}/pictures")
	public List<Picture> listPicture(@PathVariable (value="id")Shop shopid){
		List<Picture> lista = new ArrayList<>();
		try {
			for (Picture picture:pictureServiceImpl.listPictures()) {
				if (picture.getShop().equals(shopid)) { // Se comprueba que el shop_id coincida con la tienda introducida
					lista.add(picture);
				}
			}
		
		} catch (Exception e) {
		}
		return lista;
	}
	
	/**
     * Método que borra todos los cuadros de una tienda introducida en la petición
     * @return nada
     * (GET /shops/{ID}/pictures).
     */
	
	@DeleteMapping("/shops/{id}/pictures")
	public void deletePicture(@PathVariable(name = "id") Shop shopid) {
		for (Picture picture:pictureServiceImpl.listPictures()) {
			if (picture.getShop().equals(shopid)) {
				pictureServiceImpl.deletePicture(picture);
			}
		}

	}
	
}
