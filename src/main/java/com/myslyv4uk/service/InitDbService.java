package com.myslyv4uk.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myslyv4uk.entity.Role;
import com.myslyv4uk.repositories.CityRepository;
import com.myslyv4uk.repositories.CountryRepository;
import com.myslyv4uk.repositories.ItemRepository;
import com.myslyv4uk.repositories.RoleRepository;
import com.myslyv4uk.repositories.UserRepository;

@Service
public class InitDbService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @PostConstruct
    public void init() {
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleRepository.save(adminRole);

        Role moderatorRole = new Role();
        moderatorRole.setRole("MODERATOR");
        roleRepository.save(moderatorRole);

        Role userRole = new Role();
        userRole.setRole("USER");
        roleRepository.save(userRole);
        // 6.34
    }
}
