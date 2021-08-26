package com.curso.m14.service.Impl;

import java.util.List;

import com.curso.m14.model.Shops;

public interface IShopsService {

	List<Shops> getAllShops() ;

	Shops getShopsById(int id) ;

	void saveOrUpdate(Shops shops) ;

	void delete(int id) ;

	void update(Shops shops, int shopid) ;
	
}
