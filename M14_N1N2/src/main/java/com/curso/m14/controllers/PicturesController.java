package com.curso.m14.controllers;


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

import com.curso.m14.model.*;
import com.curso.m14.service.Impl.IPicturesService;
import com.curso.m14.service.Impl.IShopsService;

@Controller
@RequestMapping("")
public class PicturesController {

	@Autowired
	IShopsService shopsService;

	@Autowired
	IPicturesService picturesService;


	@GetMapping("/picture/{shopid}")
	private String getShops(@PathVariable("shopid") int shopid, Model model) {
		model.addAttribute("picture", new Pictures());
		model.addAttribute("shopId", shopid);
		return "picture";
	}
}
