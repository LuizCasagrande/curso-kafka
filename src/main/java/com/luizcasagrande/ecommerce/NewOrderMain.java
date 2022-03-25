package com.luizcasagrande.ecommerce;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try (var dispatcher = new KafkaDispatcher()) {
            for (int i = 0; i < 10; i++) {

                String key = UUID.randomUUID().toString();
                String value = key + ",34534,2572457";
                dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);

                String email = "Thank you! We are processing your order!";
                dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
            }
        }
    }
}
