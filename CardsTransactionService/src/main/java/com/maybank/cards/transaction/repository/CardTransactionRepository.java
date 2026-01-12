package com.maybank.cards.transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maybank.cards.transaction.entity.CardTransaction;

@Repository
public interface CardTransactionRepository extends JpaRepository<CardTransaction, Long> {

    List<CardTransaction> findByCardNumberOrderByTransactionDateDesc(String cardNumber);
}