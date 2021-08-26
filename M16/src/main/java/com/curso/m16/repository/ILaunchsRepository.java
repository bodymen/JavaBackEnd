package com.curso.m16.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.m16.model.*;

public interface ILaunchsRepository extends JpaRepository<Launchs, Integer> {

	List<Launchs> findAllByPlayerId(int playerId);
	
}
