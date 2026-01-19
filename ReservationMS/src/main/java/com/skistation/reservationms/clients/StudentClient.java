package com.skistation.reservationms.clients;

import com.skistation.reservationms.configuration.FeignClientConfigStudent;
import com.skistation.reservationms.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "STUDENTMS",
    configuration = FeignClientConfigStudent.class,
    url = "http://campstone-security-student-ms:8084")
public interface StudentClient {

  @GetMapping("/students/{id}")
  public StudentDTO getStudentById(@PathVariable Long id);
}
