package com.example.CarSale.Brand;

import com.example.CarSale.Car.Car;
import com.example.CarSale.Concessionary.Concessionary;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Brand {

    @Id
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    @JoinColumn(name = "brand_id")
    private Set<Car> brandList = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "BrandInConcessionary",
            joinColumns = @JoinColumn(name= "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "concessionary_id")
    )
    @JsonIgnoreProperties
    private Set<Concessionary> concessionaryList = new HashSet<>();
}
