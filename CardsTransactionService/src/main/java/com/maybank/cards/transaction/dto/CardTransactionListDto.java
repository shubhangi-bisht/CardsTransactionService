package com.maybank.cards.transaction.dto;

import java.util.List;

public class CardTransactionListDto {
	private List<CardTransactionResponseDto> transactions;

	public List<CardTransactionResponseDto> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<CardTransactionResponseDto> transactions) {
		this.transactions = transactions;
	}
	

}
