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
@Table(name = "users")
public class User {

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "account_id", nullable = false)
  public Address address;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  String userName;
  String firstName;
  String lastName;

  public User(Integer id, String userName, String firstName, String lastName, Address address) {
    this.id = id;
    this.userName = userName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }

  public User() {}
}
