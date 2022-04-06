package com.example.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer {
	public void send(String message) {
		final String TOPIC_NAME ="click-log";

		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");    // kafka host 및 server 설정
		properties.put("key.serializer", StringSerializer.class.getName());
		properties.put("value.serializer", StringSerializer.class.getName());

		// producer 생성
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

		ProducerRecord record = new ProducerRecord<String, String>(TOPIC_NAME, message);
		// message 전달
		producer.send(record);

		// 종료
		// producer.flush();
		producer.close();
	}
}
