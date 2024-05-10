package com.example.quotems.service;

import com.example.quotems.dto.QuoteDTO;
import com.example.quotems.entity.Quote;
import com.example.quotems.repo.QuoteRepo;
import com.example.quotems.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@Service
public class QuoteService {

    @Autowired
    private QuoteRepo quoteRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveQuote(QuoteDTO quoteDTO){
        if (quoteRepo.existsById(quoteDTO.getId())){
            return VarList.RSP_DUPLICATED;
        } else {
            Quote quote = modelMapper.map(quoteDTO, Quote.class);
            quoteRepo.save(quote);
            return VarList.RSP_SUCCESS;
        }
    }

    public QuoteDTO searchQuote(String field){
        Optional<Quote> quoteOptional = quoteRepo.findByField(field);
        if (quoteOptional.isPresent()) {
            Quote quote= quoteOptional.get();
            return modelMapper.map(quote, QuoteDTO.class);
        } else {
            return null;
        }
    }

    public List<QuoteDTO> getAllFields(){
        List<Quote> quoteList = quoteRepo.findAll();
        return modelMapper.map(quoteList,new TypeToken<ArrayList<QuoteDTO>>(){
        }.getType());
    }
}
