package com.tn.activemqexample.controller;

import com.tn.activemqexample.model.Customer;
import com.tn.activemqexample.model.MessageStorage;
import com.tn.activemqexample.producer.JmsProducer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customerQService")
public class CustomerController {

    private JmsProducer jmsProducer;
    private MessageStorage customerStorage;

    public CustomerController(JmsProducer jmsProducer, MessageStorage customerStorage) {
        this.jmsProducer = jmsProducer;
        this.customerStorage = customerStorage;
    }

    @PostMapping("/customers")
    public Customer postCustomer(@RequestBody Customer customer){
        jmsProducer.send(customer);
        return customer;
    }

    @GetMapping("/customers")
    public List getAllCustomers() {
        List<Customer> customers = customerStorage.getAll();
        return customers;
    }

    @DeleteMapping("/customers/clear")
    public String clearCustomerStorage(){
        customerStorage.clear();
        return "Customer Storage cleared...";
    }

}
