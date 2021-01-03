package com.example.CarSale.Brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/brand")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping
    public Iterable<Brand> getBrand(){
        return brandRepository.findAll();
    }

    @GetMapping("search/{brandId}")
    public Optional<Brand> getBrand(@PathVariable("brandId") int brandId){
        return brandRepository.findById(brandId);
    }

    @PostMapping("add")
    public Brand addBrand(@RequestBody Brand brand){
        return brandRepository.save(brand);
    }

    @DeleteMapping("delete/{brandId}")
    public void deleteBrand(@PathVariable("brandId") int brandId){
        brandRepository.deleteById(brandId);
    }

    @PutMapping("update/{brandId}")
    public ResponseEntity<Brand> updateBrand(@PathVariable("brandId") int brandId, @RequestBody Brand brandDetails) throws Exception {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new Exception("Brand not found for this id :: " + brandId));

        brand.setName(brandDetails.getName());
        final Brand updatedBrand = brandRepository.save(brand);
        return ResponseEntity.ok(updatedBrand);
    }
}
