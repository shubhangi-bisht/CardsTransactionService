package com.maybank.cards.transaction.util;

import org.springframework.stereotype.Service;

import com.maybank.cards.transaction.dto.CardTransactionResponseDto;
import com.maybank.cards.transaction.entity.CardTransaction;

@Service
public class Mapper {
	
	
	public static CardTransactionResponseDto toMap(CardTransaction cardTransactionDtls) {
		CardTransactionResponseDto cardTransactionResponseDto=  new CardTransactionResponseDto();
		
		cardTransactionResponseDto.setAccountNumber
		(MaskingUtil.maskAccountNumber(cardTransactionDtls.getAccountNumber()));
		cardTransactionResponseDto.setCardNumber
		(MaskingUtil.maskAccountNumber(cardTransactionDtls.getCardNumber()));
		cardTransactionResponseDto.setAmount(cardTransactionDtls.getAmount());
		cardTransactionResponseDto.setStatus(cardTransactionDtls.getStatus());
		cardTransactionResponseDto.setTransactionId(cardTransactionDtls.getTransactionId());
		cardTransactionResponseDto.setTransactionType(cardTransactionDtls.getTransactionType());
		
		return cardTransactionResponseDto;
		
	}
	
	

}
