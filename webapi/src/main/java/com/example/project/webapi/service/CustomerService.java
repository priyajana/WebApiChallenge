package com.example.project.webapi.service;

import com.example.project.webapi.model.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CustomerService {

    private ObjectMapper objectMapper;

    public CustomerService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;

    }

    public List<Customer> loadCustomers(){
        try
         {
             InputStream inputStream = new ClassPathResource("data.json").getInputStream();

            return objectMapper.readValue(inputStream, new TypeReference<List<Customer>> () {});


         } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file", e);
        }
    }

    public Customer getCustomerData(int customerId) {
        List<Customer> customers = loadCustomers();
        if (customers != null && !customers.isEmpty()) {
            Customer customer = customers.stream().filter(c->c.getCustomerId()==customerId).findFirst().orElseThrow(()->new RuntimeException("Customer not found"));

            int totalRewardPoints = 0;
            if(customer.getTransactions()!=null){
                for( String date : customer.getTransactions().keySet()){
                    int amt = customer.getTransactions().get(date);
                    if(amt > 100){
                        totalRewardPoints+=(amt-100)*2 + 50;
                    }
                    else if(amt > 50){
                        totalRewardPoints+=(amt - 50);
                    }
                }
                customer.setRewardPoints(totalRewardPoints);

            }
            return customer;
        }
        return null;
    }



}
