package com.curso.m14.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.m14.model.Shops;
import com.curso.m14.repository.IShopsRepository;
import com.curso.m14.service.Impl.IShopsService;


@Service
public class ShopsService implements IShopsService{
	
	@Autowired
	IShopsRepository shopsRepository;

	public List<Shops> getAllShops() {
		List<Shops> shops = new ArrayList<Shops>();
		shopsRepository.findAll().forEach(s -> shops.add(s));
		return shops;
	}

	public Shops getShopsById(int id) {
		return shopsRepository.findById(id).get();
	}

	public void saveOrUpdate(Shops shops) {
		shopsRepository.save(shops);
	}

	public void delete(int id) {
		shopsRepository.deleteById(id);
	}

	public void update(Shops shops, int shopid) {
		shopsRepository.save(shops);
	}
}