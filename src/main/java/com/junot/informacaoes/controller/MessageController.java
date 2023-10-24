package com.junot.informacaoes.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.junot.informacaoes.domain.model.Message;
import com.junot.informacaoes.service.MessageService;


@RestController
@RequestMapping("/messages")
@CrossOrigin(origins="*", maxAge=3600)
public class MessageController {

	private final MessageService messageService;

	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Message> findById(@PathVariable Long id) {
		var message = messageService.findById(id);

		return ResponseEntity.ok(message);
	}

	@PostMapping
	public ResponseEntity<Message> create(@RequestBody Message message) {
		var messageNew = messageService.create(message);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(messageNew.getId())
				.toUri();

		return ResponseEntity.created(location).body(messageNew);
	}
}
