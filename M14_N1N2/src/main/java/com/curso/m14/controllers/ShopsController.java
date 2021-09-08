package com.curso.m14.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.m13.model.Empleado;
import com.curso.m14.model.*;
import com.curso.m14.service.Impl.IPicturesService;
import com.curso.m14.service.Impl.IShopsService;

@Controller
@RequestMapping("")
public class ShopsController {

	@Autowired
	IShopsService shopsService;

	@Autowired
	IPicturesService picturesService;

	@GetMapping("/")
	private String getAllShops() {
		return "redirect:/shop";
	}

	@GetMapping("/shop")
	private String getAllShops(Model model) {
		List<Shops> shops = shopsService.getAllShops();
		model.addAttribute("shops", shops);
		return "listShops";
	}

	//NO SE USAN
//	@GetMapping("/shop/{shopid}")
//	private Shops getShops(@PathVariable("shopid") int shopid) {
//		return shopsService.getShopsById(shopid);
//	}
//
//	@DeleteMapping("/shop/{shopid}")
//	private void deleteShop(@PathVariable("shopid") int shopid) {
//		shopsService.delete(shopid);
//	}

	@PostMapping(value = "/shop", consumes = { MediaType.ALL_VALUE })
	private String saveShop(Shops shops, RedirectAttributes redirectAttrs) {
		shopsService.saveOrUpdate(shops);
		redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/shop";
	}

	//NO SE USA
//	@PutMapping("/shop")
//	private Shops update(@RequestBody Shops shops) {
//		shopsService.saveOrUpdate(shops);
//		return shops;
//	}

	/***************** PICTURES *********************/

	@PostMapping(value = "/shop/{shopId}/pictures", consumes = { MediaType.ALL_VALUE })
	public String createPictureForhop(@PathVariable(value = "shopId") int shopId, Pictures picture,
			RedirectAttributes redirectAttrs) throws Exception {
		
		picture.setShop(shopsService.getShopsById(shopId));
		
		if(picture.getAuthor().trim().isEmpty())
			picture.setAuthor("Anonymous");
		
		if (picture.getShop().getQuantity() > getAllPicturesByShop(shopId).size())
			picturesService.saveOrUpdate(picture);
		else {
			redirectAttrs.addFlashAttribute("mensaje", " Superado el maximo permitido").addFlashAttribute("clase","danger");
			//throw new Exception(" Superado el maximo permitido.");
		}

		redirectAttrs.addFlashAttribute("mensaje", "Actualizado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/shop/" + shopId + "/pictures";
	}
	

	@GetMapping("/shop/{shopid}/pictures")
	private String getPictureByShop(@PathVariable("shopid") int shopid, Model model) {
		List<Pictures> pictures = getAllPicturesByShop(shopid);
		model.addAttribute("pictures", pictures);
		model.addAttribute("shopId", shopid);
		return "listPictures";
	}

	@DeleteMapping("/shop/{shopid}/pictures")
	private String deletePicturesForShop(@PathVariable("shopid") int shopid, RedirectAttributes redirectAttrs) {
		List<Pictures> pictures = picturesService.getAllPictures();
		pictures = pictures.stream().filter(p -> p.getShop().getId() == shopid).collect(Collectors.toList());
		picturesService.deleteAllByShop(pictures);

		redirectAttrs.addFlashAttribute("mensaje", "Borrado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/shop";

	}
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam(name = "shopId", required = false, defaultValue = "0") int shopId,
			ModelAndView model) {
		return "redirect:/shop/" + shopId + "/pictures";
	}

	private List<Pictures> getAllPicturesByShop(int shopid) {
		List<Pictures> pictures = picturesService.getAllPictures();
		pictures = pictures.stream().filter(p -> p.getShop().getId() == shopid).collect(Collectors.toList());
		return pictures;
	}

}
