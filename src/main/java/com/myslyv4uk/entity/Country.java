package com.myslyv4uk.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.google.common.base.Objects;

@Entity
@Table(name = "COUNTRIES")
public class Country {

    @Id
    @SequenceGenerator(name = "countries_id_seq", sequenceName = "countries_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countries_id_seq")
    @Column(name = "country_id", unique = true, nullable = false)
    private Integer countryId;

    @Column(name = "name", length = 64)
    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<City> cities;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<User> users;

    public Country() {
        super();
    }

    public Country(String name) {
        this.name = name;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(countryId, name, cities, users);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Country) {
            Country that = (Country) object;
            return Objects.equal(this.countryId, that.countryId) && Objects.equal(this.name, that.name)
                    && Objects.equal(this.cities, that.cities) && Objects.equal(this.users, that.users);
        }
        return false;
    }
}
