package com.azl.lararestfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azl.lararestfulapi.model.Vendors;

@Repository
public interface VendorsRepository extends JpaRepository<Vendors, Integer> {

}
