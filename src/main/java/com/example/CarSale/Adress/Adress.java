package com.example.CarSale.Adress;

import com.example.CarSale.Concessionary.Concessionary;
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
public class Adress {

    @Id
    private int id;
    private String adress;

    @OneToMany
    @JoinColumn(name = "adress_id")
    private Set<Concessionary> adressList = new HashSet<>();
}
