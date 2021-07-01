package com.service.generator.service;

import com.service.generator.bean.Domain;
import com.service.generator.bean.DomainList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class DomainCrawlerService {
    private static final String KAFKA_TOPIC = "test-webdomains";
    @Autowired
    private KafkaTemplate<String, Domain> kaktaTemplate;

    public void crawl(String name) {
        Mono<DomainList> domainListMono = WebClient.create()
                .get()
                .uri(String.format("https://api.domainsdb.info/v1/domains/search?domain=%s", name))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(DomainList.class);

        //domainListMono.

        Optional<DomainList> domains = domainListMono.blockOptional();



        domains.ifPresent(
                domainList -> domainList.getDomains().forEach(
                        domain -> {
                            kaktaTemplate.send(KAFKA_TOPIC, domain);
                            System.out.println("Sending using block optional : " + domain.getDomain() + "on topic " + KAFKA_TOPIC);

                        }
                ));


//        domainListMono.subscribe(
//                domainList -> {
//                    domainList.getDomains().forEach(
//                            domain -> {
//                                kaktaTemplate.send(KAFKA_TOPIC, domain);
//                                System.out.println("Sending " + domain.getDomain() + "on topic " + KAFKA_TOPIC);
//
//                            }
//                    );
//
//                }
//        );
    }
}
