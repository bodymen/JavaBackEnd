package com.curso.m14.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.m14.model.Pictures;
import com.curso.m14.model.Shops;
import com.curso.m14.service.Impl.IPicturesService;
import com.curso.m14.service.Impl.IShopsService;

@RestController
public class ShopsController {

	@Autowired
	IShopsService shopsService;

	@Autowired
	IPicturesService picturesService;

	@GetMapping("/shop")
	private List<Shops> getAllShops() {
		return shopsService.getAllShops();
	}

	@GetMapping("/shop/{shopid}")
	private Shops getShops(@PathVariable("shopid") int shopid) {
		return shopsService.getShopsById(shopid);
	}

	@DeleteMapping("/shop/{shopid}")
	private void deleteShop(@PathVariable("shopid") int shopid) {
		shopsService.delete(shopid);
	}

	@PostMapping("/shop")
	private int saveShop(@RequestBody Shops shops) {
		shopsService.saveOrUpdate(shops);
		return shops.getId();
	}

	@PutMapping("/shop")
	private Shops update(@RequestBody Shops shops) {
		shopsService.saveOrUpdate(shops);
		return shops;
	}

	/***************** PICTURES  *********************/

	@PostMapping("/shop/{shopId}/pictures")
	public Pictures createPictureForhop(@PathVariable(value = "shopId") int shopId, @RequestBody Pictures picture) throws Exception {
		picture.setShop(shopsService.getShopsById(shopId));
		if (picture.getShop().getQuantity() <= getAllPicturesByShop(shopId).size())
			picturesService.saveOrUpdate(picture);
		else
			throw new Exception(" Superado el maximo permitido.");
			
		return picture;
	}

	@GetMapping("/shop/{shopid}/pictures")
	private List<Pictures> getPictureByShop(@PathVariable("shopid") int shopid) {
		return getAllPicturesByShop(shopid);
	}

	@DeleteMapping("/shop/{shopid}/pictures")
	private void deletePicturesForShop(@PathVariable("shopid") int shopid) {
		List<Pictures> pictures = picturesService.getAllPictures();
		pictures = pictures.stream().filter(p -> p.getShop().getId() == shopid).collect(Collectors.toList());
		picturesService.deleteAllByShop(pictures);
	}

	private List<Pictures> getAllPicturesByShop(int shopid) {
		List<Pictures> pictures = picturesService.getAllPictures();
		pictures = pictures.stream().filter(p -> p.getShop().getId() == shopid).collect(Collectors.toList());
		return pictures;
	}

}
