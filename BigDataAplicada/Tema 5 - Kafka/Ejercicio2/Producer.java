package com.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.UUID;

public class Producer {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            for (int i = 0; i < 100000; i++) {
                Thread.sleep(1000);
                String timestamp = LocalDateTime.now().format(formatter);
                String uuid = UUID.randomUUID().toString();

                String message = String.format(
                        "{ \"id\": \"%s\", \"numero\": %d, \"timestamp\": \"%s\", \"mensaje\": \"Este es el mensaje número %d\" }",
                        uuid, i, timestamp, i);

                System.out.println("\nEnviando: " + message);

                kafkaProducer.send(new ProducerRecord<>("myTopic", Integer.toString(i), message));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            kafkaProducer.close();
        }
    }
}