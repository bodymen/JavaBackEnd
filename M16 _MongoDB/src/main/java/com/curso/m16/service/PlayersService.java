package com.curso.m16.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.m16.model.Launchs;
import com.curso.m16.model.Players;
import com.curso.m16.repository.ILaunchsRepository;
import com.curso.m16.repository.IPlayerRepository;
import com.curso.m16.service.Impl.IPlayersService;

@Service
public class PlayersService implements IPlayersService {

	@Autowired
	IPlayerRepository playerRepository;
	@Autowired
	ILaunchsRepository launchsRepository;

	public List<Players> getAllPlayers() {
		List<Players> players = new ArrayList<Players>();
		playerRepository.findAll().forEach(s -> players.add(s));
		return players;
	}

	public Players getPlayersById(UUID id) {
		return playerRepository.findById(id).get();
	}

	public void saveOrUpdate(Players players) {
		playerRepository.save(players);
	}

	public void delete(UUID id) {
		playerRepository.deleteById(id);
	}

	public void update(Players players, UUID playerid) {
		playerRepository.save(players);
	}

	public double getRankingPlayers() {
		List<Players> listPlayers = getAllPlayers();
		return listPlayers.stream().mapToDouble(p ->p.getPromedio()).sum() / Double.valueOf(listPlayers.size());
	}

	public double getRankingPlayerLoser() {
		List<Players> listPlayers = getAllPlayers();
		return listPlayers.stream()
				.mapToDouble(p ->p.getPromedio())
				.min()
				.orElseThrow(NoSuchElementException::new);
	
	}

	public double getRankingPlayerWinner() {
		List<Players> listPlayers = getAllPlayers();
		return listPlayers.stream()
				.mapToDouble(p ->p.getPromedio())
				.max()
				.orElseThrow(NoSuchElementException::new);
		
		/*  Otra forma de hacerlo devolviento Objeto Players.
		 * 
		 * return listPlayers.stream()
				.min(Comparator.comparing(Players::getPromedio))
				.orElseThrow(NoSuchElementException::new);
		 * 
		 * 
		 */
	}

}