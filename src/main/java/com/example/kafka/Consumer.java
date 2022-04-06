package com.example.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class Consumer {
	public void getMessage() {
		String TOPIC_NAME ="click-log";

		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");    // kafka host 및 server 설정
		properties.put("group.id", "click_log_group");
		properties.put("key.deserializer", StringDeserializer.class.getName());
		properties.put("value.deserializer", StringDeserializer.class.getName());

		System.out.println("Consumer.test");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);    // consumer 생성

		consumer.subscribe(Arrays.asList(TOPIC_NAME));      // topic 설정

		while (true) {  // 계속 loop를 돌면서 producer의 message를 띄운다.
			ConsumerRecords<String, String> records = consumer.poll(500);
			for (ConsumerRecord<String, String> record : records) {
				String s = record.topic();
				if (TOPIC_NAME.equals(s)) {
					System.out.println("received message(consumer) : "+record.value());
				}else{
					System.out.println(" not Topic");
				}
			}
		}
	}
}
