package com.azl.lararestfulapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azl.lararestfulapi.model.Vendors;
import com.azl.lararestfulapi.service.VendorsService;

@RestController
public class MainController {
	
	@Autowired
	VendorsService vendorService;
	
	@GetMapping("/")
	public String helloHomePage() {
		return "Restful respond";
	}
	@GetMapping("vendors")
	public List<Vendors> getAllVendors(){
		return vendorService.findAllVendors();
	}
	
	@PostMapping("vendors")
	public Vendors createVendor(@RequestBody Vendors vendor ){
		return vendorService.saveVendor(vendor);
	}

}
