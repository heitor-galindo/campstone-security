package com.ebanking.accountms.entities;

import com.ebanking.accountms.enums.AccountType;
import com.ebanking.accountms.enums.CardType;
import com.ebanking.accountms.model.Card;
import com.ebanking.accountms.model.Customer;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.EnumSet;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long accountId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private AccountType accountType;

  @Embedded private Card card;

  @Column(nullable = false)
  private BigDecimal amount;

  @Column(nullable = false)
  private BigDecimal debitAmount;

  @Embedded private Customer customer;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDateTime creationDate;

  private Account(
      AccountType accountType,
      Card card,
      BigDecimal amount,
      BigDecimal debitAmount,
      Customer customer) {
    this.accountType = accountType;
    this.card = card;
    this.amount = amount;
    this.debitAmount = debitAmount;
    this.customer = customer;
  }

  public static Account newAccount(
      AccountType accountType,
      Customer customer,
      BigDecimal initialAmount,
      BigDecimal initialDebitAmount) {

    Card card = null;

    if (accountType == AccountType.CHECKING) {
      card = Card.newCard(customer.getFullName(), EnumSet.of(CardType.DEBIT, CardType.CREDIT));
    }

    return new Account(
        accountType,
        card,
        defaultAmount(initialAmount),
        defaultAmount(initialDebitAmount),
        customer);
  }

  private static BigDecimal defaultAmount(BigDecimal value) {
    return value != null ? value : BigDecimal.ZERO;
  }
}
