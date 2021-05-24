package com.tn.activemqexample.configuration;

import com.tn.activemqexample.model.MessageStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageStorageConfig {

    @Bean
    public MessageStorage getCustomerStorage(){
        return new MessageStorage();
    }
}
