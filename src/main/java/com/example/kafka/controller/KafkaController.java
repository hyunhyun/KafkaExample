package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.Consumer;
import com.example.kafka.Producer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class KafkaController {

	@PostMapping(value = "/push")
	public ResponseEntity saveHelp(@RequestBody String message) {

		System.out.println("KafkaController.saveHelp");
		System.out.println("message = " + message);

		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		System.out.println("====producer======");
		producer.send(message);
		System.out.println("======consumer===========");
		consumer.getMessage();
		return new ResponseEntity(HttpStatus.OK);
	}
}
