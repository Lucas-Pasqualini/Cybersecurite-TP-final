package com.example.CarSale.Character;

import com.example.CarSale.Car.Car;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private Set<Car> customerList = new HashSet<>();
}
