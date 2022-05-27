package com.ritesh.audit.service;

import com.ritesh.audit.entity.Address;
import com.ritesh.audit.entity.User;
import com.ritesh.audit.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

  @Autowired private UserRepository repository;

  @Transactional
  public void getUser() {
    Optional<User> user = repository.findById(1);
    Address address = user.get().getAddress();
    log.info("address :: {}", address.getContact());
  }
}
