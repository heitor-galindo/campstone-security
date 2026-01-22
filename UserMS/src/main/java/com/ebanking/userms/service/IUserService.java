package com.ebanking.userms.service;

import com.ebanking.userms.dto.AccountDTO;
import com.ebanking.userms.entities.User;

public interface IUserService {
  User addReservation(AccountDTO student);
}
