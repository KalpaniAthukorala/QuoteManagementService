package com.example.quotems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@CrossOrigin
public class ResponseDTO {
    private String code;
    private String message;
    private Object content;
}
