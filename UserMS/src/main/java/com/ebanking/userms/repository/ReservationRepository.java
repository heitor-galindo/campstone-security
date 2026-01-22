package com.ebanking.userms.repository;

import com.ebanking.userms.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<User, Long> {}
