package com.ebanking.userms.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @NonNull
  @Column(nullable = false)
  String customerName;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  LocalDateTime creationDate;
}
