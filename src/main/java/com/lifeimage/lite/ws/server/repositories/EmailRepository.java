package com.lifeimage.lite.ws.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifeimage.lite.ws.server.beans.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
  
}
