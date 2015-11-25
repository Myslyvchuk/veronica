package com.myslyv4uk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myslyv4uk.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
