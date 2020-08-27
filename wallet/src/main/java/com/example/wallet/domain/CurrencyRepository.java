package com.example.wallet.domain;

import org.springframework.data.repository.CrudRepository;
import com.example.wallet.entity.Currency;


public interface CurrencyRepository extends CrudRepository<Currency, Long> {
    
}