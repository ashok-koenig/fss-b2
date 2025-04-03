package com.example.rest_api.controller;

import com.example.rest_api.entity.Customer;
import com.example.rest_api.exception.CustomerNotFoundException;
import com.example.rest_api.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.customerService.saveCustomer(customer));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customer = this.customerService.getCustomerById(id).orElseThrow(()-> new CustomerNotFoundException(id));
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer){
        this.customerService.getCustomerById(id).orElseThrow(()-> new CustomerNotFoundException(id));
        customer.setId(id);
        return ResponseEntity.ok(this.customerService.saveCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id){
        this.customerService.getCustomerById(id).orElseThrow(()-> new CustomerNotFoundException(id));
        this.customerService.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
