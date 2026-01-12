package com.maybank.cards.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.cards.transaction.dto.CardTransactionListDto;
import com.maybank.cards.transaction.dto.CardTransactionRequestDto;
import com.maybank.cards.transaction.dto.CardTransactionResponseDto;
import com.maybank.cards.transaction.service.CardTransactionService;

@RestController
@RequestMapping("/card/transactions")
public class TransactionController {
	
	@Autowired
	private CardTransactionService cardTransactionService;
	
    @PostMapping(value = "/fetchTransactionList")
    public ResponseEntity<CardTransactionListDto> getTransactions
    (@RequestBody CardTransactionRequestDto cardTransactionRequestDto) 
    {
    	CardTransactionListDto response = new CardTransactionListDto();
		System.out.println("cardTransactionRequestDto: "+cardTransactionRequestDto.getCardNumber());
        List<CardTransactionResponseDto> transactions = cardTransactionService.getRecentTransactionsByCard(cardTransactionRequestDto);
        
        if (transactions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        
        
        response.setTransactions(transactions);
        
        return ResponseEntity.ok(response);
    }
	
}


