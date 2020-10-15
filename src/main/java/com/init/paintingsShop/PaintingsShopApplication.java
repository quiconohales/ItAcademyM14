package com.init.paintingsShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * Ejercicio 12 It Academy spring boot 
 * Clase main de la aplicación que simula una tienda de cuadros
 * donde se pueden realizar operciones de:
 * -Creación tienda
 * -Listar tiendas
 * -Añadir cuadro a una tienda concreta
 * -Listar cuadros de una tienda concreta
 * -Eliminar todos los cuadros de la tienda (no se elimina la tienda)
 * 
 * 
@autor Francesc Nohales
@version 1.0
*/
@SpringBootApplication
public class PaintingsShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaintingsShopApplication.class, args);
	}

}
