package com.curso.m16.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.curso.m16.model.Players;

public interface IPlayerRepository extends MongoRepository<Players, UUID> {

}
