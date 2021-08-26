package com.curso.m14.repository;

import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.curso.m14.model.Pictures;

public interface IPicturesRepository extends JpaRepository<Pictures, Integer> {

//	  Page<Pictures> findByShopId(Long postId, Pageable pageable);
//    Optional<Pictures> findByIdAndShopId(Long id, Long postId);
}
