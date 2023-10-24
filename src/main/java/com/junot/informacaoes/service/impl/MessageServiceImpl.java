package com.junot.informacaoes.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.junot.informacaoes.domain.model.Message;
import com.junot.informacaoes.domain.repository.MessageRepository;
import com.junot.informacaoes.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	private final MessageRepository messageRepository;

	public MessageServiceImpl(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public Message findById(Long id) {

		return messageRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Message create(Message messageToCreate) {
		// TODO Auto-generated method stub
		return messageRepository.save(messageToCreate);
	}

}
