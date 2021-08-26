package com.curso.m16.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.m16.model.Launchs;
import com.curso.m16.model.Players;
import com.curso.m16.service.Impl.ILaunchsService;
import com.curso.m16.service.Impl.IPlayersService;

@RestController
public class PlayersController {

	@Autowired
	IPlayersService playersService;

	@Autowired
	ILaunchsService launchsService;
	
	@GetMapping("/player")
	private List<Players> getAllPlayers() {
		return playersService.getAllPlayers();
	}

	@GetMapping("/player/{playerid}")
	private Players getPlayers(@PathVariable("playerid") int playerid) {
		return playersService.getPlayersById(playerid);
	}

	@DeleteMapping("/player/{playerid}")
	private void deletePlayer(@PathVariable("playerid") int playerid) {
		playersService.delete(playerid);
	}

	@PostMapping("/player")
	private String savePlayer(@RequestBody Players player) {

		if (player.getName().trim().isEmpty() && player.isAnomin() == false)
			return "Nombre no puede estar vacio";
		else {
			if (player.isAnomin() == true)
				player.setName(null);
			try {
				playersService.saveOrUpdate(player);
			} catch (Exception e) {
				//  Transaction().rollback(); UnitOfWork ?? 
				//  *** Aumenta el ID aunque no inserta! ****
				return "Nombre debe ser unico";
			}
		}
		return String.valueOf(player.getId());
	}

	@PutMapping("/player")
	private Players update(@RequestBody Players player) {
		playersService.saveOrUpdate(player);
		return player;
	}

	/***************** LAUNCH (tiradas-games) *********************/

	/**
	 * Un jugador específic realitza una tirada dels daus.
	 * Actulitzo el promedi de les seves tirades (launchs)
	 * @param playerId
	 * @param launch
	 * @return
	 */
	// Yo hubiera puesto /LAUNCH en lugar /games")
	@PostMapping("/player/{playerId}/games")
	public Launchs createLaunchForPlayer(@PathVariable(value = "playerId") int playerId, @RequestBody Launchs launch) {

		launch.setPlayer(playersService.getPlayersById(playerId));
		launch.setDice1(UtilHelper.GetNumber());
		launch.setDice2(UtilHelper.GetNumber());
		if (launch.getDice1() + launch.getDice2() == 7) {
			launch.setWon(true);
		} else {
			launch.setWon(false);
		}

		launchsService.saveOrUpdate(launch);
		launchsService.UpdatePromedio(launch.getPlayer());

		return launch;
	}

	// Yo hubiera puesto /launchs")
	@DeleteMapping("/player/{playerid}/games")
	private void deleteLaunchsForPlayer(@PathVariable("playerid") int playerId) {
		List<Launchs> launchs = launchsService.findAllByPlayers(playerId);
		launchsService.deleteAllByPlayer(launchs);
		//Reset Promedio = 0
		Players p = playersService.getPlayersById(playerId);
		p.setPromedio(0.0);
		playersService.saveOrUpdate(p);
	}

	// Yo hubiera puesto /launchs")
	@GetMapping("/player/{playerid}/games")
	private List<Launchs> getLaunchsByPlayer(@PathVariable("playerid") int playerId) {
		return launchsService.findAllByPlayers(playerId);
	}

	/***************** RANKING *********************/

	@GetMapping("/player/ranking")
	private double getRankingPlayers() {
		return playersService.getRankingPlayers()*100;
	}

	@GetMapping("/player/ranking/loser")
	private double getRankingPlayerLoser() {
		return playersService.getRankingPlayerLoser()*100;
	}

	@GetMapping("/player/ranking/winner")
	private double getRankingPlayerWinner() {
		return playersService.getRankingPlayerWinner()*100;
	}

}
