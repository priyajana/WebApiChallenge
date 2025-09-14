package com.example.project.webapi.model;

import java.util.Map;

public class Customer {

    private Long customerId;
    private String name;
    private Map<String,Integer> transactions;
    private int rewardPoints;

    public Customer(Long customerId, String name, Map<String,Integer> transactions, int rewardPoints) {
        this.customerId = customerId;
        this.name = name;
        this.transactions = transactions;
        this.rewardPoints = rewardPoints;
    }

    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Map<String,Integer> getTransactions() {
        return transactions;
    }
    public void setTransactions(Map<String,Integer> transactions) {
        this.transactions = transactions;
    }
    public int getRewardPoints() {
        return rewardPoints;
    }
    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

}
