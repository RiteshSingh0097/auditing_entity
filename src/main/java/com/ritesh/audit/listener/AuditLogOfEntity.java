package com.ritesh.audit.listener;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuditLogOfEntity {

  private Map<String, String> preRequest = new HashMap<>();

  private Map<String, String> postRequest = new HashMap<>();

  public Map<String, String> getPreRequest() {
    return preRequest;
  }

  public void setPreRequest(String name, String preRequest) {
    this.preRequest.put(name, preRequest);
  }

  public Map<String, String> getPostRequest() {
    return postRequest;
  }

  public void setPostRequest(String name, String postRequest) {
    this.postRequest.put(name, postRequest);
  }
}
