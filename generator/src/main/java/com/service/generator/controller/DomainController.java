package com.service.generator.controller;

import com.service.generator.service.DomainCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class DomainController {

    @Autowired
    DomainCrawlerService crawlerService;

    @GetMapping("/lookup/{domainName}")
    public String lookup(@PathVariable final String domainName) {
        System.out.println("Received name: " + domainName);
        Executors.newSingleThreadExecutor().submit(() -> crawlerService.crawl(domainName));
        return "Sent on the kafka topic for name : "+ domainName;
    }

}
