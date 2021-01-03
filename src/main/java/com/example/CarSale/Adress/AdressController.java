package com.example.CarSale.Adress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/adress")
public class AdressController {

    @Autowired
    private AdressRepository adressRepository;

    @GetMapping
    public Iterable<Adress> getAdress(){
        return adressRepository.findAll();
    }

    @GetMapping("search/{adressId}")
    public Optional<Adress> getAdress(@PathVariable("adressId") int adressId){
        return adressRepository.findById(adressId);
    }

    @PostMapping("add")
    public Adress addAdress(@RequestBody Adress adress){
        return adressRepository.save(adress);
    }

    @DeleteMapping("delete/{adressId}")
    public void deleteAdress(@PathVariable("adressId") int adressId){
        adressRepository.deleteById(adressId);
    }

    @PutMapping("update/{adressId}")
    public ResponseEntity<Adress> updateAdress(@PathVariable("adressId") int adressId, @RequestBody Adress adressDetails) throws Exception {
        Adress adress = adressRepository.findById(adressId)
                .orElseThrow(() -> new Exception("Adress not found for this id :: " + adressId));

        adress.setAdress(adressDetails.getAdress());
        final Adress updatedAdress = adressRepository.save(adress);
        return ResponseEntity.ok(updatedAdress);
    }
}
