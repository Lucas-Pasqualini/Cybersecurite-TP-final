package com.example.CarSale.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public Iterable<Car> getCar(){
        return carRepository.findAll();
    }

    @GetMapping("search/{carId}")
    public Optional<Car> getCar(@PathVariable("carId") int carId){
        return carRepository.findById(carId);
    }

    @PostMapping("add")
    public Car addCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    @DeleteMapping("delete/{carId}")
    public void deleteCar(@PathVariable("carId") int carId){
        carRepository.deleteById(carId);
    }

    @PutMapping("update/{carId}")
    public ResponseEntity<Car> updateCar(@PathVariable("carId") int carId, @RequestBody Car carDetails) throws Exception {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new Exception("Car not found for this id :: " + carId));

        car.setName(carDetails.getName());
        final Car updatedCar = carRepository.save(car);
        return ResponseEntity.ok(updatedCar);
    }
}
