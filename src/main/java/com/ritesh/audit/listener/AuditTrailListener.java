package com.ritesh.audit.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

@Slf4j
@Component
public class AuditTrailListener {

  @Autowired private AuditLogOfEntity auditLogOfEntity;

  @Autowired private ObjectMapper objectMapper;

  @PostPersist
  @PostUpdate
  @PostRemove
  private void afterAnyUpdate(Object object) {
    try {
      auditLogOfEntity.setPostRequest(
          object.getClass().getSimpleName(), objectMapper.writeValueAsString(object));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  @PostLoad
  private void afterLoad(Object object) {
    try {
      auditLogOfEntity.setPreRequest(
          object.getClass().getSimpleName(), objectMapper.writeValueAsString(object));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
