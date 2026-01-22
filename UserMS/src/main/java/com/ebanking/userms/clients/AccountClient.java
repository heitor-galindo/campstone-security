package com.ebanking.userms.clients;

import com.ebanking.userms.configuration.FeignClientConfigAccount;
import com.ebanking.userms.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ACCOUNT-SERVICE", configuration = FeignClientConfigAccount.class)
public interface AccountClient {

  @PostMapping("/account")
  Long createAccount(@RequestParam String userId, @RequestParam String userName);
}
