package com.bbarros.protobuff;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class CreatePersonController {
    private final SendPersonSaveGateway sendPersonSaveGateway;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    void createPerson(@RequestBody PersonRequest personRequest)
    {
        sendPersonSaveGateway.publish(personRequest);
    }
}
