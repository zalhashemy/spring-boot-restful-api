package com.azl.lararestfulapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azl.lararestfulapi.model.Vendors;
import com.azl.lararestfulapi.repository.VendorsRepository;

@Service
public class VendorsServiceImpl implements VendorsService {
	
	@Autowired
	VendorsRepository vendorsRepository;

	@Override
	public List<Vendors> findAllVendors() {
		return vendorsRepository.findAll();
	}

	@Override
	public Vendors saveVendor(Vendors vendor) {
		return vendorsRepository.save(vendor);
	}

	@Override
	public Optional<Vendors> findVendorById(Integer id) {
		return vendorsRepository.findById(id);
	}

	@Override
	public void deleteVendor(Integer id) {
		 vendorsRepository.deleteById(id);
	}

}
