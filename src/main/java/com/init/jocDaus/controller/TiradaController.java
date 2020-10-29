package com.init.jocDaus.controller;

import java.util.ArrayList;
import java.util.Collections;
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

import com.init.jocDaus.dto.Player;
import com.init.jocDaus.dto.Tirada;
import com.init.jocDaus.service.PlayerServiceImpl;
import com.init.jocDaus.service.TiradaServiceImpl;
//import com.init.jocDaus.service.PlayerServiceImpl;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/tiradas")
public class TiradaController {

	@Autowired
	TiradaServiceImpl tiradaServiceImpl;
	///////////////////////////////////////////////////// y ee aaa
	@Autowired
	PlayerServiceImpl playerServiceImpl;

	/**
	 * 3 - Postman Método que agrega un tirada introducido en la petición, en caso
	 * que no se introduzca el jugador muestra error
	 * 
	 * @return Tirada (POST/post/shops/{shopid})
	 */
	@PostMapping("/post/player/{playerid}/games") // {player_id}
	public ResponseEntity<Tirada> saveTirada(@PathVariable(value = "playerid") Integer playerid) {
		try {
			Player player1 = playerServiceImpl.getPlayer(playerid);
			Tirada Tirada_player1 = new Tirada();
			Tirada_player1.setPlayer(player1);
			return new ResponseEntity<>(tiradaServiceImpl.saveTirada(Tirada_player1), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			System.out.println("THIS PLAYER NOT EXIST");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}

	/**
	 * 4 - Postman Método que borra todos los tiradas de una player introducido en
	 * la petición
	 * 
	 * @return nada (GET /player/{ID}/tiradas).
	 */

	@DeleteMapping("/players/{id}/games")
	public ResponseEntity<String> deleteTirada(@PathVariable(name = "id") Player playerid) {
		boolean find = false;
		for (Tirada tirada : tiradaServiceImpl.listTirada()) {
			if (tirada.getPlayer().equals(playerid)) {
				tiradaServiceImpl.deleteTirada(tirada);
				find = true;
			}
		}
		if (!find) {
			return new ResponseEntity<>("THIS PLAYER NOT EXIST", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("Tirada borrada", HttpStatus.OK);
	}

	/**
	 * 5 - Postman Método que lista todos los players con su % medio d'exits
	 * 
	 * @return List<Tirada> (GET /shops/{ID}/pictures).
	 */
	@GetMapping("/players")
	public List<Player> listMitjana() {
		Double winner;
		Double losser;
		Double half;
		List<Tirada> lista = new ArrayList<>();

		try {
			for (Player player : playerServiceImpl.listPlayer()) {
				winner = 0.0;
				losser = 0.0;
				half = 0.0;
				for (Tirada tirada : tiradaServiceImpl.listTirada()) {
					if (tirada.getPlayer().equals(player)) {
						if (tirada.isWin()) {
							winner++;
						} else {
							losser++;
						}
					}
				}
				half += 100 * (double) (Math.round(winner / (winner + losser) * 100d) / 100d);
				player.setSuccess(half);
				playerServiceImpl.savePlayer(player).setSuccess(half);

			}

			return playerServiceImpl.listPlayer();
		} catch (Exception e) {
		}
		return playerServiceImpl.listPlayer();
	}

	/**
	 * 6 - Postman Método que lista las tiradas de un player introducido en la
	 * petición
	 * 
	 * @return List<Tirada> (GET /shops/{ID}/pictures).
	 */
	@GetMapping("/players/{id}/games")
	public List<Tirada> listTirada(@PathVariable(value = "id") Player playerid) {
		List<Tirada> lista = new ArrayList<>();
		try {
			for (Tirada tirada : tiradaServiceImpl.listTirada()) {
				if (tirada.getPlayer().equals(playerid)) {
					lista.add(tirada);
				}
			}

		} catch (Exception e) {
		}
		return lista;
	}

	/**
	 * 7 - Postman Método que lista el  % medio d'exits
	 * 
	 * @return List<Tirada> (GET/players/ranking).
	 */
	@GetMapping("/players/ranking")
	public Double ranking() {
		Double winner;
		Double losser;
		Double half;
		Double mediageneral = 0.0;
		//Player millor = new Player();
		try {
			for (Player player : playerServiceImpl.listPlayer()) { // Recorremos todos los jugadores
				winner = 0.0;
				losser = 0.0;
				half = 0.0;
				for (Tirada tirada : tiradaServiceImpl.listTirada()) { // Recorremos las tiradas acumulando ganadas y perdidas
					if (tirada.getPlayer().equals(player)) {
						if (tirada.isWin()) {
							winner++;
						} else {
							losser++;
						}
					}
				}
				// Se actualiza en campo Success con su porcentaje de exito
				half += 100 * (double) (Math.round(winner / (winner + losser) * 100d) / 100d);
				//player.setSuccess(half);
				playerServiceImpl.savePlayer(player).setSuccess(half);
			}
			
			Double suma = 0.0;
			
			for (Player player : playerServiceImpl.listPlayer()) {
				suma=suma+player.getSuccess();
				}
				mediageneral=(double) (Math.round(suma / (playerServiceImpl.listPlayer().size()))*100d/100d);
			
		} catch (Exception e) {
		}
		return mediageneral;
	}
	/**
	 *  * 8 - Postman Método que lista el player con peor % d'exits
	 * 
	 * @return List<Tirada> (GET /players/ranking/winner).
	 */
	@GetMapping("/players/ranking/loser")
	public Player pitjorporcen() {
		Double winner;
		Double losser;
		Double half;
		Player pitjor = new Player();
		try {
			for (Player player : playerServiceImpl.listPlayer()) { // Recorremos todos los jugadores
				winner = 0.0;
				losser = 0.0;
				half = 0.0;
				for (Tirada tirada : tiradaServiceImpl.listTirada()) { // Recorremos las tiradas acumulando ganadas y perdidas
					if (tirada.getPlayer().equals(player)) {
						if (tirada.isWin()) {
							winner++;
						} else {
							losser++;
						}
					}
				}
				// Se actualiza en campo Success con su porcentaje de exito
				half += 100 * (double) (Math.round(winner / (winner + losser) * 100d) / 100d);
				playerServiceImpl.savePlayer(player).setSuccess(half);
			}
			// Se busca el jugador con menor porcentaje de exito
			Double maxi = 100.0;
			for (Player player : playerServiceImpl.listPlayer()) {
				
				if (player.getSuccess() < maxi) {
					maxi = player.getSuccess();
					pitjor = player;
				}
			}
		} catch (Exception e) {
		}
		return pitjor;
	}
	/**
	 * 9 - Postman Método que lista el player con mejor % d'exits
	 * 
	 * @return List<Tirada> (GET/players/ranking/winner).
	 */
	@GetMapping("/players/ranking/winner")
	public Player millorporcen() {
		Double winner;
		Double losser;
		Double half;
		Player millor = new Player();
		try {
			for (Player player : playerServiceImpl.listPlayer()) { // Recorremos todos los jugadores
				winner = 0.0;
				losser = 0.0;
				half = 0.0;
				for (Tirada tirada : tiradaServiceImpl.listTirada()) { // Recorremos las tiradas acumulando ganadas y perdidas
					if (tirada.getPlayer().equals(player)) {
						if (tirada.isWin()) {
							winner++;
						} else {
							losser++;
						}
					}
				}
				// Se actualiza en campo Success con su porcentaje de exito
				half += 100 * (double) (Math.round(winner / (winner + losser) * 100d) / 100d);
				playerServiceImpl.savePlayer(player).setSuccess(half);
			}
			// Se busca el jugador con mayor porcentaje de exito
			Double maxi = 0.0;
			for (Player player : playerServiceImpl.listPlayer()) {
				
				if (player.getSuccess() > maxi) {
					maxi = player.getSuccess();
					millor = player;
				}
			}
		} catch (Exception e) {
		}
		return millor;
	}
}
