package com.example.quotems.repo;
import com.example.quotems.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuoteRepo  extends JpaRepository<Quote,Integer> {
    Optional<Quote> findByField(String field);
}
