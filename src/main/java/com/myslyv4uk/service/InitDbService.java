package com.myslyv4uk.service;

import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myslyv4uk.entity.City;
import com.myslyv4uk.entity.Country;
import com.myslyv4uk.entity.Gender;
import com.myslyv4uk.entity.Role;
import com.myslyv4uk.entity.User;
import com.myslyv4uk.entity.UserState;
import com.myslyv4uk.repository.CityRepository;
import com.myslyv4uk.repository.CountryRepository;
import com.myslyv4uk.repository.ItemRepository;
import com.myslyv4uk.repository.RoleRepository;
import com.myslyv4uk.repository.UserRepository;

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
    @Transactional
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

        Country country = new Country("Ukraine");
        countryRepository.save(country);
        City city = new City("Lviv", country);
        cityRepository.save(city);

        User adminUser = new User();
        adminUser.setFirstName("Bogdan");
        adminUser.setLastName("Myslyvchuk");
        adminUser.setLogin("Ronan");
        adminUser.setPassword("123456");
        adminUser.setEmail("myslyv4uk@gmail.com");
        adminUser.setGender(Gender.MALE);
        adminUser.setUserState(UserState.ACTIVE);
        adminUser.setRole(adminRole);
        adminUser.setBirthday(new GregorianCalendar(2015, 01, 01));
        adminUser.setRegion("Lvivs'ka oblast'");
        adminUser.setCountry(country);
        adminUser.setCity(city);
        userRepository.save(adminUser);
    }
}
