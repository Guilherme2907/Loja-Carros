/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.domain.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Guilherme
 */
public class UserNewDTO implements Serializable {

    @NotBlank(message = "nome obrigatório")
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Email(message = "Email inválido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "cpf obrigatório")
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotBlank(message = "rua obrigatória")
    @Column(nullable = false)
    private String street;

    @NotBlank(message = "número obrigatório")
    @Column(nullable = false)
    private String number;

    private String complement;

    @NotBlank(message = "bairro obrigatório")
    @Column(nullable = false)
    private String neighborhood;

    @NotBlank(message = "cep obrigatório")
    @Column(nullable = false)
    private String cep;

    private Long cityId;
    
    @NotBlank(message = "ao menos 1 telefone deve ser informado")
    @Column(nullable = false)
    private String telephone1;

    private String telephone2;

    public UserNewDTO() {
    }

    public UserNewDTO(String nome, String email, String cpf, String street, String number, String complement, String neighborhood, String cep, Long cityId, String telephone1, String telephone2) {
        this.name = nome;
        this.email = email;
        this.cpf = cpf;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.cep = cep;
        this.cityId = cityId;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    } 
}
