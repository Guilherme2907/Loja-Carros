/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Guilherme
 */
@Entity
public class State extends AbstractEntity<Long> {

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "state")
    private Set<City> Cities = new HashSet();

    public State() {
    }

    public State(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Set<City> getCities() {
        return Cities;
    }

    public void setCities(Set<City> Cities) {
        this.Cities = Cities;
    }
}
