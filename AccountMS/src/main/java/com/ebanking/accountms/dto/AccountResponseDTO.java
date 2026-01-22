package com.ebanking.accountms.dto;

import com.ebanking.accountms.enums.AccountType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountResponseDTO {

  private Long accountId;
  private AccountType accountType;
  private BigDecimal amount;
  private BigDecimal debitAmount;
  private LocalDateTime creationDate;
  private CardDTO card;
  private CustomerDTO customer;

  public AccountResponseDTO(
      Long accountId,
      AccountType accountType,
      BigDecimal amount,
      BigDecimal debitAmount,
      LocalDateTime creationDate,
      CardDTO card,
      CustomerDTO customer) {
    this.accountId = accountId;
    this.accountType = accountType;
    this.amount = amount;
    this.debitAmount = debitAmount;
    this.creationDate = creationDate;
    this.card = card;
    this.customer = customer;
  }
}
