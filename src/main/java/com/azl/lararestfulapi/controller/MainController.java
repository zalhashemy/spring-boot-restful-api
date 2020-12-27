package com.azl.lararestfulapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("vendors/{id}")
	public Optional<Vendors> getVendorById(@PathVariable Integer id){
		return vendorService.findVendorById(id);
	}
	
	@PostMapping("vendors")
	public Vendors createVendor(@RequestBody Vendors vendor ){
		return vendorService.saveVendor(vendor);
	}
	
	@PutMapping("vendors/{id}")
	public Vendors updateVendor(@RequestBody Vendors vendor,@PathVariable Integer id ){
		vendorService.findVendorById(id).orElseThrow(NullPointerException::new);
		return vendorService.saveVendor(vendor);
	}
	
	@DeleteMapping("vendors/{id}")
	public ResponseEntity<?> deleteVendor(@PathVariable Integer id ){
		 vendorService.deleteVendor(id);
		 return new ResponseEntity(id, HttpStatus.OK);
	}

}
