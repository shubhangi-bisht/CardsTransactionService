package com.maybank.cards.transaction.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CARD_TRANSACTION_MASTER")
public class CardTransaction {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID", nullable = false, length = 20)
    private Long transactionId;

    @Column(name = "ACCOUNT_NUMBER",nullable = false, length = 20)
    private String accountNumber;

    @Column(name = "CARD_NUMBER",nullable = false, length = 20)
    private String cardNumber;

    @Column(name = "TRANSACTION_DATE",nullable = false)
    private LocalDateTime transactionDate;

    @Column(name = "TRANSACTION_TYPE",nullable = false, length = 10)
    private String transactionType; // DEBIT / CREDIT

    @Column(name = "DESCRIPTION",length = 255)
    private String description;

    @Column(name = "AMOUNT",nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "STATUS",length = 20)
    private String status = "SUCCESS";
    
    public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}

