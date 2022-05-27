package com.ritesh.audit.entity;

import com.ritesh.audit.listener.AuditTrailListener;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@EntityListeners({AuditTrailListener.class})
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "address")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  Long contact;
}
