package com.myslyv4uk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CITIES")
public class City {

    @Id
    @SequenceGenerator(name = "cities_country_id_seq", sequenceName = "cities_country_id_seq", allocationSize = 111)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cities_country_id_seq")
    @Column(name = "city_id", unique = true, nullable = false)
    private Integer cityId;
}
