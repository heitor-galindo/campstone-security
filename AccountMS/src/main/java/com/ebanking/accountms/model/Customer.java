package com.ebanking.accountms.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
  private String customerId;
  private String fullName;
}
