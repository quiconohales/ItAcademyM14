package com.init.jocDaus.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.init.jocDaus.dto.Player;
import com.init.jocDaus.dto.Tirada;
import com.init.jocDaus.service.PlayerServiceImpl;

@RestController
@RequestMapping("/player")
public class PlayerController {
	@Autowired
	PlayerServiceImpl playerServiceImpl;
	/** 1 - Postman
     * Método que crea una Player
     * @return nada
     * (POST /Player).
     */
	@PostMapping ("/players")
	public String savePlayer(@RequestBody Player player) {
		String name_select;
		boolean duplicat=false;
		name_select = player.getName();
		for (Player player1:playerServiceImpl.listPlayer())  {
			if (player1.getName().equals(name_select)) {
				duplicat=true;
			}
		}
		if (duplicat) {
			return "Jugador Duplicat";
			}else {
			playerServiceImpl.savePlayer(player);
			return "Jugador creat correctament";
	}
	}
	/** 2 - Postman
     * Método que actualiza un Player 
     * @return nada
     * (PUT /Player).
     */
	@PutMapping("/players/{id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable(name = "id") Integer id, @RequestBody Player player) {

		Player player_select = new Player();
		player_select = playerServiceImpl.playerXID(id);
		player_select.setName(player.getName());
	
	return new ResponseEntity<>(playerServiceImpl.updatePlayer(player_select),HttpStatus.OK);
	}

	// Get Leer
	// Post Enviar/crear
	// Put actualizar y tambien crear
	// delette borrar
	
	// lista tiradas de un jugador
	@GetMapping("/players/{id}/games")
	public List<Tirada> getListTirada(@PathVariable(name = "id") Integer id) {
		Player player = playerServiceImpl.getPlayer(id);
		return player.getTirada();
	}

	
	/**
     * Método que lista los jugadores  existentes
     * @return Lista de jugadores
     * (GET /shops/{ID}/pictures).
     */
	@GetMapping("/get")
	public ResponseEntity<List<Player>> listPlayer() {
		return ResponseEntity.ok(playerServiceImpl.listPlayer());
	}


}
