package com.example.rest_api.service;

import com.example.rest_api.entity.Customer;
import com.example.rest_api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @CacheEvict(value = "customers", allEntries = true)
    @Transactional
    public Customer saveCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    @Cacheable(value = "customers")
    public List<Customer> getAllCustomers(){
        return this.customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id){
        return this.customerRepository.findById(id);
    }

    @CacheEvict(value = "customers", allEntries = true)
    @Transactional
    public void deleteCustomerById(Long id){
        this.customerRepository.deleteById(id);
    }
}
