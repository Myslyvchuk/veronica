package com.myslyv4uk.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES")
public class Country {

    @Id
    @SequenceGenerator(name = "countries_country_id_seq", sequenceName = "countries_country_id_seq",
            allocationSize = 111)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countries_country_id_seq")
    @Column(name = "country_id", unique = true, nullable = false)
    private Integer countryId;

    @Column(name = "name")
    private String name;

    private List<City> cities;

}
