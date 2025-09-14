package com.example.project.webapi.controller;

import com.example.project.webapi.model.Customer;
import com.example.project.webapi.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController (CustomerService customerService) {
        this.customerService =  customerService;
    }

    @GetMapping("/customer/{id}")
    public Customer  getCustomerData(@PathVariable int id) {
        return customerService.getCustomerData(id);
    }

}
