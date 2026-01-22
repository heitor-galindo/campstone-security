package com.ebanking.userms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDTO {
  private Long accountId;
  private Long customerId;
  private String accountType;
  private Long cardNumber;
}
