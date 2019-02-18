package com.guilherme.lojacarros.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Guilherme
 */
public class UserNewDTO {

    @NotEmpty(message = "nome obrigatório")
    private String name;

    @NotBlank
    @Email(message = "Email inválido")
    private String email;
    
    @NotBlank
    private String password;

    @CPF(message = "CPF inválido")
    @NotBlank(message = "cpf obrigatório")
    private String cpf;

    @NotBlank(message = "rua obrigatória")
    @Column(nullable = false)
    private String street;

    @NotBlank(message = "número obrigatório")
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

    public UserNewDTO(String nome, String email, String cpf, String street, String number, String complement, String neighborhood,
            String cep, Long cityId, String telephone1, String telephone2,String password) {
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
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "UserNewDTO{" + "name=" + name + ", email=" + email + ", cpf=" + cpf + ", street=" + street + ", number=" + number + ", complement=" + complement + ", neighborhood=" + neighborhood + ", cep=" + cep + ", cityId=" + cityId + ", telephone1=" + telephone1 + ", telephone2=" + telephone2 + '}';
    }

}
