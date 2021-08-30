package com.curso.m16.service.Impl;

import java.util.List;
import java.util.UUID;

import com.curso.m16.model.Launchs;
import com.curso.m16.model.Players;

public interface ILaunchsService {

	List<Launchs> getAllLaunchs() ;

	Launchs getLaunchsById(UUID id) ;

	void saveOrUpdate(Launchs launch) ;

	void delete(UUID id) ;

	void update(Launchs launch) ;

	void deleteAllByPlayer(List<Launchs> launchs);

	List<Launchs> findAllByPlayers(UUID id);

	void UpdatePromedio(Players player);
	
}
