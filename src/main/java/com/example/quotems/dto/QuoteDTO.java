package com.example.quotems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@AllArgsConstructor
@NoArgsConstructor
@Data
@CrossOrigin
public class QuoteDTO {

    private int id;
    private String field;
    private String quote;
}
