package com.curso.m16.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.m16.controller.common.UtilHelper;
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
	private Players getPlayers(@PathVariable("playerid") UUID playerid) {
		Players players = null;
		try {
			players = playersService.getPlayersById(playerid);
		} catch (NoSuchElementException e) {
			// TODO ResourceNotFoundException
			return null;
		}
		return players;
	}

	@DeleteMapping("/player/{playerid}")
	private void deletePlayer(@PathVariable("playerid") UUID playerid) {
		playersService.delete(playerid);
	}

	@PostMapping("/player")
	private String savePlayer(@RequestBody Players player) {

		if (player.getName().trim().isEmpty() && player.isAnomin() == false)
			return "Nombre no puede estar vacio";
		else {
			try {
				playersService.saveOrUpdate(player);
			} catch (Exception e) {
				return "Nombre debe ser unico";
			}
		}
		return String.valueOf(player.getId());
	}

	@PutMapping("/player")
	private Players update(@RequestBody Players player) {
		try {
			playersService.saveOrUpdate(player);
		} catch (Exception e) {
			// TODO 
			// throw new ResourceNotFoundException("Resource not found!");
			return null;
		}
		return player;
	}

	/***************** LAUNCH (tiradas-games) *********************/

	@PostMapping("/player/{playerId}/games")
	public Launchs createLaunchForPlayer(@PathVariable(value = "playerId") UUID playerId, @RequestBody Launchs launch) {

		try {
			launch.setPlayer(playersService.getPlayersById(playerId));
			launch.setDice1(UtilHelper.GetNumber());
			launch.setDice2(UtilHelper.GetNumber());
			launch.setDice3(UtilHelper.GetNumber());
			launch.setDice4(UtilHelper.GetNumber());
			if (launch.getDice1() + launch.getDice2() +launch.getDice3() + launch.getDice4()  == 7) {
				launch.setWon(true);
			} else {
				launch.setWon(false);
			}

			launchsService.saveOrUpdate(launch);
			launchsService.UpdatePromedio(launch.getPlayer());
			
		} catch (NoSuchElementException e) {
			// TODO 
			return null;
		}
		return launch;
	}

	@DeleteMapping("/player/{playerid}/games")
	private void deleteLaunchsForPlayer(@PathVariable("playerid") UUID playerId) {
		try {
			List<Launchs> launchs = launchsService.findAllByPlayers(playerId);
			launchsService.deleteAllByPlayer(launchs);
			// Reset Promedio = 0
			Players p = playersService.getPlayersById(playerId);
			p.setPromedio(0.0);
			playersService.saveOrUpdate(p);
		} catch (NoSuchElementException e) {
			// TODO  
		}
	}

	@GetMapping("/player/{playerid}/games")
	private List<Launchs> getLaunchsByPlayer(@PathVariable("playerid") UUID playerId) {
		List<Launchs> launchs = null;
		try {
			 launchs = launchsService.findAllByPlayers(playerId);
		} catch (NoSuchElementException e) {
			// TODO ResourceNotFoundException
			return null;
		}
		return launchs;
	}

	/***************** RANKING *********************/

	@GetMapping("/player/ranking")
	private double getRankingPlayers() {
		return playersService.getRankingPlayers() * 100;
	}

	@GetMapping("/player/ranking/loser")
	private double getRankingPlayerLoser() {
		return playersService.getRankingPlayerLoser() * 100;
	}

	@GetMapping("/player/ranking/winner")
	private double getRankingPlayerWinner() {
		return playersService.getRankingPlayerWinner() * 100;
	}

}
