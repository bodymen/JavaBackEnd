package com.curso.m14.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.m14.model.Shops;

public interface IShopsRepository extends JpaRepository<Shops, Integer> {

}
