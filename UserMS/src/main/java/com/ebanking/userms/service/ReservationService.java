package com.ebanking.userms.service;

import com.ebanking.userms.dto.AccountDTO;
import com.ebanking.userms.entities.User;
import com.ebanking.userms.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReservationService implements IUserService {

  private static final String TOPIC = "reservation-event";
  private final ReservationRepository reservationRepository;
  @Autowired private KafkaTemplate<String, ReservationEvent> kafkaTemplate;

  public ReservationService(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public User addReservation(AccountDTO student) {
    User user = reservationRepository.save(new User(student.getId()));
    ReservationEvent event =
        new ReservationEvent(user.getIdReservation(), user.getStudentId());
    kafkaTemplate.send(TOPIC, event);

    return user;
  }
}
