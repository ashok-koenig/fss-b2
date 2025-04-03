package com.example.rest_api.service;

import com.example.rest_api.entity.Customer;
import com.example.rest_api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Async
    public CompletableFuture<String> processLongRunningTask(){
        System.out.println("Processing in background");
        try {
            Thread.sleep(5000); // Simulate long-running task
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.completedFuture("Task completed");
    }

    @Transactional
    public Customer saveCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return this.customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id){
        return this.customerRepository.findById(id);
    }

    @Transactional
    public void deleteCustomerById(Long id){
        this.customerRepository.deleteById(id);
    }
}
