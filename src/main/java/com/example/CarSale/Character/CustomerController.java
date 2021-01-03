package com.example.CarSale.Character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public Iterable<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping("search/{customerId}")
    public Optional<Customer> getCustomer(@PathVariable("customerId") int customerId){
        return customerRepository.findById(customerId);
    }

    @PostMapping("add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @DeleteMapping("delete/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerRepository.deleteById(customerId);
    }

    @PutMapping("update/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customerDetails) throws Exception {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new Exception("Car not found for this id :: " + customerId));

        customer.setName(customerDetails.getName());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }
}
