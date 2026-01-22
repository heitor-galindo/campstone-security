package com.ebanking.accountms.model;

import com.ebanking.accountms.enums.CardType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class Card {

  @Column(nullable = false)
  private String cardHolder;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EnumSet<CardType> cardTypes;

  @Column(nullable = false)
  private String cardNumber;

  @Column(nullable = false)
  private BigDecimal limit;

  protected Card() {}

  public static Card newCard(String cardHolder, EnumSet<CardType> cardTypes) {
    return new Card(cardHolder, cardTypes, generateCardNumber(), BigDecimal.valueOf(500L));
  }

  private static String generateCardNumber() {
    return String.valueOf(
        ThreadLocalRandom.current().nextLong(1_0000_0000_0000_000L, 10_0000_0000_0000_000L));
  }
}
