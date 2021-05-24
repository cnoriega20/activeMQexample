package com.tn.activemqexample.model;

import java.util.ArrayList;
import java.util.List;

/*Class to store Customer List*/
public class MessageStorage {
    private List<Customer> customers = new ArrayList<>();

    public void add(Customer customer) {
        customers.add(customer);
    }

    public void clear() {
        customers.clear();
    }

    public List getAll(){
        return customers;
    }
}
