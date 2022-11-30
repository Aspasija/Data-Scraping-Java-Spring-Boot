package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import javax.swing.text.Document;

@RestController
public class APIcontroller {
    
    @Autowired
    private RestTemplate restTemplate;

    List<String> websites = Arrays.asList("https://www.result.si/projekti/", 
        "https://www.result.si/o-nas/", 
        "https://www.result.si/kariera/", 
        "https://www.result.si/blog/");

    @GetMapping("/data-scraping")
    public List<Object> getData(@RequestParam(required = true) int numberOfWebsites) {
        List<String> websitesToScrape = websites.subList(0, numberOfWebsites);
    
        for (String website : websitesToScrape) {
            Document doc = Jsoup.connect(website).get();
            // tukaj moram izpisati besedilo naslova z vsake strani in ga shraniti v skupno globalno spremenljivko
        }
    }
}