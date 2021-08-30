package com.curso.m16.repository;


import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.curso.m16.model.*;

public interface ILaunchsRepository extends MongoRepository<Launchs, UUID> {

	List<Launchs> findAllByPlayerId(UUID playerId);
	
	@Query("{playerId:'?0'}")
	List<Launchs> findCustomByPlayerId(UUID playerId);
}
