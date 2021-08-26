package com.curso.m16.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.m16.model.Players;

public interface IPlayerRepository extends JpaRepository<Players, Integer> {

}
