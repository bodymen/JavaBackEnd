package com.curso.m16.service.Impl;

import java.util.List;

import com.curso.m16.model.Players;

public interface IPlayersService {

	List<Players> getAllPlayers() ;

	Players getPlayersById(int id) ;

	void saveOrUpdate(Players players) ;

	void delete(int id) ;

	void update(Players players, int playerid) ;

	double getRankingPlayers();

	double getRankingPlayerLoser();

	double getRankingPlayerWinner();
	
}
