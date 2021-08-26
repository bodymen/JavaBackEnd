package com.curso.m16.service.Impl;

import java.util.List;

import com.curso.m16.model.Launchs;
import com.curso.m16.model.Players;

public interface ILaunchsService {

	List<Launchs> getAllLaunchs() ;

	Launchs getLaunchsById(int id) ;

	void saveOrUpdate(Launchs launch) ;

	void delete(int id) ;

	void update(Launchs launch, int shopid) ;

	void deleteAllByPlayer(List<Launchs> launchs);

	List<Launchs> findAllByPlayers(int id);

	void UpdatePromedio(Players player);
	
}
