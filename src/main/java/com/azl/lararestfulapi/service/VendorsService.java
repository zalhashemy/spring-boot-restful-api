package com.azl.lararestfulapi.service;

import java.util.List;
import java.util.Optional;

import com.azl.lararestfulapi.model.Vendors;

public interface VendorsService {
	
	public List<Vendors> findAllVendors();

	public Vendors saveVendor(Vendors vendor);

	public Optional<Vendors> findVendorById(Integer id);

	public void deleteVendor(Integer id);

}
