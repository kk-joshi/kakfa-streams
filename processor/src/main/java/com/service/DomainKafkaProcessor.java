package com.service;

import com.service.processor.bean.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class DomainKafkaProcessor {
    @Bean
    public Function<KStream<String, Domain>, KStream<String, Domain>> processActiveDomains() {
        return kStream -> kStream.filter( (key, domain) -> {
            System.out.println("Active domain "+ domain.getDomain());
            return !domain.getIsDead();
        });
    }

//    @Bean
//    public Function<KStream<String, Domain>, KStream<String, Domain>> processInActiveDomains() {
//        return kStream -> kStream.filter( (key, domain) -> {
//            System.out.println("Inactive domain "+ domain.getDomain());
//            return domain.getIsDead();
//        });
//    }
}
