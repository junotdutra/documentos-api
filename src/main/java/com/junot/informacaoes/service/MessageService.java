package com.junot.informacaoes.service;

import com.junot.informacaoes.domain.model.Message;

public interface MessageService {

	Message findById(Long id);
	Message create(Message messageToCreate);
}
