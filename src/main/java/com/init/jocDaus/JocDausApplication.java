package com.init.jocDaus;

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
public class JocDausApplication {

	public static void main(String[] args) {
		SpringApplication.run(JocDausApplication.class, args);
	}
//	ok 1 POST: /players : crea un jugador
//	ok 2 PUT /players : modifica el nom del jugador
//	ok 3 POST /players/{id}/games/ : un jugador específic realitza una tirada dels daus.
//	ok 4 DELETE /players/{id}/games: elimina les tirades del jugador
//	o GET /players/: retorna el llistat de tots els jugadors del sistema amb el seu percentatge mig d’èxits
//	ok 6 GET /players/{id}/games: retorna el llistat de jugades per un jugador.
//	o GET /players/ranking: retorna el ranking mig de tots els jugadors del sistema. És a dir, el percentatge mig d’èxits.
//	o GET /players/ranking/loser: retorna el jugador amb pitjor percentatge d’èxit
//	o GET /players/ranking/winner: retorna el jugador amb pitjor percentatge d’èxit
}
