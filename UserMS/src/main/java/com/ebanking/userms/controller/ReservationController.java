package com.ebanking.userms.controller;

import com.ebanking.userms.clients.AccountClient;
import com.ebanking.userms.dto.AccountDTO;
import com.ebanking.userms.entities.User;
import com.ebanking.userms.service.IUserService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/user")
public class ReservationController {

  @Autowired private AccountClient accountClient;
  @Autowired private IUserService reservationService;

  @GetMapping
  public ResponseEntity<List<AccountDTO>> getAllAccounts() {
    List<AccountDTO> studentsWithReservations = accountClient.getStudentsWithReservations();
    return new ResponseEntity<>(studentsWithReservations, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<User> addReservation(@RequestParam Long studentId) {
    AccountDTO student = accountClient.getStudentById(studentId);
    if (student == null) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "Student not found with ID " + studentId);
    }
    log.info("Creating reservation for student: {}", student.getFirstName());
    User user = reservationService.addReservation(student);

    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }
}
