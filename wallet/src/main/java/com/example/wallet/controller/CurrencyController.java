package com.example.wallet.controller;

import com.example.wallet.entity.Currency;


import com.example.wallet.domain.CurrencyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController    
public class CurrencyController {    
    
    // H2 
    private final CurrencyRepository currencyRepository;    
        
    @Autowired    
    public CurrencyController(CurrencyRepository currencyRepository) {    
        this.currencyRepository = currencyRepository;    
    }    
        
    @GetMapping("/currencies")    
    public Iterable<Currency> getCurrencies() {    
        return currencyRepository.findAll();    
    }

    @DeleteMapping("/currencies{id}")
    void deleteCurrency(@PathVariable Long id){
        currencyRepository.deleteById(id);
    }

    @PostMapping("/currencies")
    void addCurrency(@RequestBody Currency currency){
        currencyRepository.save(currency);
        System.out.println("Added Currency:");
        System.out.println("Name: " + currency.getName());
        System.out.println("Code: " + currency.getCode());
        System.out.println("Amount: " + currency.getAmount());
        System.out.println("Rate: " + currency.getRate());
    }

    @PutMapping("/currencies")
    void updateCurrency(@RequestBody Currency currency){
        currencyRepository.save(currency);
    }

}    