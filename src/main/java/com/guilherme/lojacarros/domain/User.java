package com.guilherme.lojacarros.domain;

import com.guilherme.lojacarros.domain.enums.Profile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "USERS")
public class User extends AbstractEntity<Long> {

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToMany(mappedBy = "client")
    private List<Car> cars = new ArrayList();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "profiles")
    private Set<Integer> profiles = new HashSet();

    public User() {
        addProfile(Profile.CLIENTE);
    }

    public User(String name, String email, String cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        addProfile(Profile.CLIENTE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addProfile(Profile p) {
        this.profiles.add(p.getCod());
    }

    public Set<Profile> getProfiles() {
        return this.profiles.stream().map(p -> Profile.toEnum(p)).collect(Collectors.toSet());
    }
}
