package com.example;

import com.github.javafaker.Faker;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer_01 {

    public static void main(String[] args){
        Faker faker = new Faker();

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        try{
            for(int i = 0; i < 100000; i++){
                Thread.sleep(1000);

                String author = faker.book().author();
                String genre = faker.book().genre();
                String publisher = faker.book().publisher();
                String title = faker.book().title();
                String quote = faker.backToTheFuture().quote();

                String message = String.format(
                    "{" +
                        "\"author\": \"%s\", " +
                        "\"genre\": \"%s\", " +
                        "\"publisher\": \"%s\", " +
                        "\"title\": \"%s\", " +
                        "\"quote\": \"%s\"" +
                    "}",
                    escape(author), escape(genre), escape(publisher), escape(title), escape(quote)
                );

                System.out.println("\n" + message);
                kafkaProducer.send(new ProducerRecord<>("quotes-input", message));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            kafkaProducer.close();
        }
    }

    private static String escape(String input) {
        return input.replace("\"", "\\\"").replace("\n", "\\n");
    }
}
