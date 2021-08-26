package com.curso.m14.service.Impl;

import java.util.List;

import com.curso.m14.model.Pictures;
import com.curso.m14.model.Shops;

public interface IPicturesService {

	List<Pictures> getAllPictures() ;

	Pictures getPicturesById(int id) ;

	void saveOrUpdate(Pictures picture) ;

	void delete(int id) ;

	void update(Pictures picture, int shopid) ;

	void deleteAllByShop(List<Pictures> pictures);
	
}
