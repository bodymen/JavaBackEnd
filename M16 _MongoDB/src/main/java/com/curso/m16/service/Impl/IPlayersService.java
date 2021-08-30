package com.curso.m16.service.Impl;

import java.util.List;
import java.util.UUID;

import com.curso.m16.model.Players;

public interface IPlayersService {

	List<Players> getAllPlayers() ;

	Players getPlayersById(UUID id) ;

	void saveOrUpdate(Players players) ;

	void delete(UUID id) ;

	void update(Players players, UUID playerid) ;

	double getRankingPlayers();

	double getRankingPlayerLoser();

	double getRankingPlayerWinner();
	
}
