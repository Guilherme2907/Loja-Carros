package com.guilherme.lojacarros.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author Guilherme
 */
@Entity
public class Car extends AbstractEntity<Long> {

    @NotBlank(message = "Vehicle Type is required")
    @Size(min = 5, max = 20, message = "Vehicle Type must be beetween {min} and {max} letters")
    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;

    @NotBlank(message = "Brand is required")
    @Size(min = 2, max = 15, message = "Brand must be beetween {min} and {max} letters")
    @Column(nullable = false)
    private String brand;

    @NotBlank(message = "Model is required")
    @Size(min = 5, max = 20, message = "Model be beetween {min} and {max} letters")
    @Column(nullable = false)
    private String model;

    @NotNull
    @Column(nullable = false)
    private String year;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2) DEFAULT 0.00")
    private Double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Car() {
    }

    public Car(Long id,String vehicleType, String brand, String model, String year, Double price, User client) {
        super(id);
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.client = client;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

}
