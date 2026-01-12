package com.maybank.cards.transaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maybank.cards.transaction.dto.CardTransactionRequestDto;
import com.maybank.cards.transaction.dto.CardTransactionResponseDto;

@Service
public interface CardTransactionService {

	List<CardTransactionResponseDto> getRecentTransactionsByCard(CardTransactionRequestDto requestDto);

}
