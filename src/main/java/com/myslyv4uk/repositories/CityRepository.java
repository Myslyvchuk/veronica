package com.myslyv4uk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myslyv4uk.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
