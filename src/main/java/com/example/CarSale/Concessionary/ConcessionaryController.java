package com.example.CarSale.Concessionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/concessionary")
public class ConcessionaryController {

    @Autowired
    private ConcessionaryRepository concessionaryRepository;

    @GetMapping
    public Iterable<Concessionary> getConcessionary(){
        return concessionaryRepository.findAll();
    }

    @GetMapping("search/{concessionaryId}")
    public Optional<Concessionary> getConcessionary(@PathVariable("concessionaryId") int concessionaryId){
        return concessionaryRepository.findById(concessionaryId);
    }

    @PostMapping("add")
    public Concessionary addConcessionary(@RequestBody Concessionary concessionary){
        return concessionaryRepository.save(concessionary);
    }

    @DeleteMapping("delete/{concessionaryId}")
    public void deleteConcessionary(@PathVariable("concessionaryId") int concessionaryId){
        concessionaryRepository.deleteById(concessionaryId);
    }

    @PutMapping("update/{concessionaryId}")
    public ResponseEntity<Concessionary> updateConcessionary(@PathVariable("concessionaryId") int concessionaryId, @RequestBody Concessionary concessionaryDetails) throws Exception {
        Concessionary concessionary = concessionaryRepository.findById(concessionaryId)
                .orElseThrow(() -> new Exception("Concessionary not found for this id :: " + concessionaryId));

        concessionary.setName(concessionaryDetails.getName());
        final Concessionary updatedConcessionary = concessionaryRepository.save(concessionary);
        return ResponseEntity.ok(updatedConcessionary);
    }
}
