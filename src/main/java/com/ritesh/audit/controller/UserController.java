package com.ritesh.audit.controller;

import com.ritesh.audit.entity.Address;
import com.ritesh.audit.listener.AuditLogOfEntity;
import com.ritesh.audit.vo.ResponseDto;
import com.ritesh.audit.entity.User;
import com.ritesh.audit.repository.AddressRepository;
import com.ritesh.audit.repository.UserRepository;
import com.ritesh.audit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

  @Autowired private AuditLogOfEntity auditLogOfEntity;

  @Autowired private UserRepository repository;

  @Autowired private AddressRepository addressRepository;

  @Autowired private UserService userService;

  @PostMapping("/data")
  public ResponseDto data(@RequestBody User user) {
    repository.save(user);
    return new ResponseDto(auditLogOfEntity.getPreRequest(), auditLogOfEntity.getPostRequest());
  }

  @GetMapping("/data")
  public ResponseDto address() {
    userService.getUser();
    return new ResponseDto(auditLogOfEntity.getPreRequest(), auditLogOfEntity.getPostRequest());
  }
}
