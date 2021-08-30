package com.curso.m16.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.m16.model.Launchs;
import com.curso.m16.model.Players;

public interface IPlayerRepository extends JpaRepository<Players, Integer> {

	List<Players> findByNameIgnoreCase(String name);
}
