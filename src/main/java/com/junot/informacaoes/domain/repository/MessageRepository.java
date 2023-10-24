package com.junot.informacaoes.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junot.informacaoes.domain.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
