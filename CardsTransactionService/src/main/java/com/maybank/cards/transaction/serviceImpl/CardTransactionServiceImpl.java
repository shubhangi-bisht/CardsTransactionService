package com.maybank.cards.transaction.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.cards.transaction.dto.CardTransactionRequestDto;
import com.maybank.cards.transaction.dto.CardTransactionResponseDto;
import com.maybank.cards.transaction.entity.CardTransaction;
import com.maybank.cards.transaction.exception.DatabaseUnavailableException;
import com.maybank.cards.transaction.exception.NoDataFoundException;
import com.maybank.cards.transaction.repository.CardTransactionRepository;
import com.maybank.cards.transaction.service.CardTransactionService;
import com.maybank.cards.transaction.util.Mapper;

@Service
public class CardTransactionServiceImpl implements CardTransactionService{

	@Autowired
	CardTransactionRepository cardTransactionRepository;

	private static final Logger logger = LogManager.getLogger(CardTransactionServiceImpl.class);

	@Override
	public List<CardTransactionResponseDto> getRecentTransactionsByCard(CardTransactionRequestDto requestDto) {
		if (requestDto == null || requestDto.getCardNumber() == null) {
			throw new IllegalArgumentException("Request or Account number cannot be null");
		}

		try {
			List<CardTransaction> transactions = 
					cardTransactionRepository.findByCardNumberOrderByTransactionDateDesc
					(requestDto.getCardNumber());

			if(Objects.nonNull(transactions)) {
				return transactions.stream().map(Mapper::toMap).collect(Collectors.toList()); 
			}
			else {
				throw new NoDataFoundException("No card found for account number "
						+ requestDto.getCardNumber());
			}
		}
		catch (Exception ex) {
			logger.error("Database error while fetching card details", ex);
			throw new DatabaseUnavailableException("Unable to fetch card details", ex);
		}

	}

}
