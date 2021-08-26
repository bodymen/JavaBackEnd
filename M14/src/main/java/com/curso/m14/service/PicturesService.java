package com.curso.m14.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.m14.model.Pictures;
import com.curso.m14.model.Pictures;
import com.curso.m14.repository.IPicturesRepository;
import com.curso.m14.service.Impl.IPicturesService;


@Service
public class PicturesService implements IPicturesService{
	
	@Autowired
	IPicturesRepository picturesRepository;

	public List<Pictures> getAllPictures() {
		List<Pictures> pictures = new ArrayList<Pictures>();
		picturesRepository.findAll().forEach(s -> pictures.add(s));
		return pictures;
	}

	public Pictures getPicturesById(int id) {
		return picturesRepository.findById(id).get();
	}

	public void saveOrUpdate(Pictures pictures) {
		picturesRepository.save(pictures);
	}

	public void delete(int id) {
		picturesRepository.deleteById(id);
	}

	public void update(Pictures pictures, int pictureid) {
		picturesRepository.save(pictures);
	}

	public void deleteAllByShop(List<Pictures> pictures) {
		picturesRepository.deleteAll(pictures);
	}
}