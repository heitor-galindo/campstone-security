package com.ebanking.accountms.controller;

import com.ebanking.accountms.dto.AccountDTO;
import com.ebanking.accountms.dto.AccountMapper;
import com.ebanking.accountms.dto.AccountResponseDTO;
import com.ebanking.accountms.dto.CustomerDTO;
import com.ebanking.accountms.entities.Account;
import com.ebanking.accountms.enums.AccountType;
import com.ebanking.accountms.repository.AccountRepository;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/account")
public class AccountController {

  @Autowired private AccountRepository accountRepository;
  @Autowired private AccountMapper accountMapper;

  @GetMapping("/all")
  public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
    List<Account> accounts = accountRepository.findAll();
    return new ResponseEntity<>(accountMapper., HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public AccountResponseDTO getAccount(@PathVariable Long id) {
    Account account = accountRepository.findById(id);
    return accountMapper.toDto(account);
  }

  @PostMapping()
  //  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Account> createAccount(@RequestBody CustomerDTO customerDTO, @RequestParam String accountType) {

    Account saved = accountRepository.save(payload);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
  }
}
