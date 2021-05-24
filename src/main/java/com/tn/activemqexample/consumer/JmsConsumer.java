package com.tn.activemqexample.consumer;

import com.tn.activemqexample.model.Customer;
import com.tn.activemqexample.model.MessageStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsConsumer {
    @Autowired
    private MessageStorage customerStorage;

    @JmsListener(destination = "${activemq.queue}",
    containerFactory = "getJmsListenerContainerFactory")
    public void receive(Customer customer) {
        log.info("Received message: " + customer);
        customerStorage.add(customer);
    }

}
