package com.myslyv4uk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myslyv4uk.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}