package com.springboot.apiwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentController {
	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	@GetMapping(value="/product")
	public String documentProduct() {
		return "product";
	}
}
