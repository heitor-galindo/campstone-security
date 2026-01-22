package com.ebanking.accountms.dto;

import com.ebanking.accountms.entities.Account;
import com.ebanking.accountms.model.Card;
import com.ebanking.accountms.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountMapper {

  public List<AccountResponseDTO> toDtoList(List<Ac>) {

  }
  public AccountResponseDTO toDto(Account account) {

    CardDTO cardDTO = null;
    if (account.getCard() != null) {
      Card card = account.getCard();
      cardDTO =
          new CardDTO(
              card.getCardHolder(), card.getCardTypes(), card.getCardNumber(), card.getLimit());
    }

    Customer customer = account.getCustomer();
    CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerId(), customer.getFullName());

    return new AccountResponseDTO(
        account.getAccountId(),
        account.getAccountType(),
        account.getAmount(),
        account.getDebitAmount(),
        account.getCreationDate(),
        cardDTO,
        customerDTO);
  }
}
