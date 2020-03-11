package com.bbarros.protobuff;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@EnableBinding(SavePersonSource.class)
@Service
@RequiredArgsConstructor
public class SendPersonSaveGateway {
    private final SavePersonSource savePersonSource;

    void publish(PersonRequest personRequest) {
        PersonMessage.personMessage personMessage = PersonMessage.personMessage
                .newBuilder()
                .setName(personRequest.getName())
                .setAge(personRequest.getAge())
                .setEmail(personRequest.getEmail())
                .build();
        savePersonSource.output().send(MessageBuilder.withPayload(personMessage.toByteArray()).build());
    }
}
