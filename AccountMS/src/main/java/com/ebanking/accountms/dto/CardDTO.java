package com.ebanking.accountms.dto;

import com.ebanking.accountms.enums.CardType;
import java.math.BigDecimal;
import java.util.Set;

public class CardDTO {

  private String cardHolder;
  private Set<CardType> cardTypes;
  private String cardNumber;
  private BigDecimal limit;

  public CardDTO(String cardHolder, Set<CardType> cardTypes, String cardNumber, BigDecimal limit) {
    this.cardHolder = cardHolder;
    this.cardTypes = cardTypes;
    this.cardNumber = cardNumber;
    this.limit = limit;
  }
}
