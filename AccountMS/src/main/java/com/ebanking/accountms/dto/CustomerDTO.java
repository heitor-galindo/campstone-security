package com.ebanking.accountms.dto;

public class CustomerDTO {

  private String customerId;
  private String fullName;

  public CustomerDTO(String customerId, String fullName) {
    this.customerId = customerId;
    this.fullName = fullName;
  }
}
