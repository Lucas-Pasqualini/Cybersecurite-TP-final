package com.example.CarSale.Concessionary;

import com.example.CarSale.Brand.Brand;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Concessionary {

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

    @ManyToMany(mappedBy = "concessionaryList")
    @JsonIgnoreProperties
    private Set<Brand> BrandList = new HashSet<>();
}
