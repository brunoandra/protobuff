package com.bbarros.protobuff;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SavePersonSource {
    @Output("save-person")
    MessageChannel output();

}
