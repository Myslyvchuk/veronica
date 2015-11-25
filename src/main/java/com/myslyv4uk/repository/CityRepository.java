package com.myslyv4uk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myslyv4uk.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
