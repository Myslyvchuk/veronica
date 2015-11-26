package com.myslyv4uk.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.google.common.base.Objects;

@Entity
@Table(name = "CITIES")
public class City {

    @Id
    @SequenceGenerator(name = "cities_id_seq", sequenceName = "cities_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cities_id_seq")
    @Column(name = "city_id", unique = true, nullable = false)
    private Integer cityId;

    @Column(name = "city_name", length = 4)
    @Size(min = 3, message = "Name must be at least 3 characters!")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<User> users;

    public City() {
        super();
    }

    public City(String name) {
        this.name = name;
    }

    public City(String name, Country country) {
        this(name);
        this.country = country;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cityId, name, country, users);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof City) {
            City that = (City) object;
            return Objects.equal(this.cityId, that.cityId) && Objects.equal(this.name, that.name)
                    && Objects.equal(this.country, that.country) && Objects.equal(this.users, that.users);
        }
        return false;
    }
}
