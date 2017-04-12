package com.example.helloworld;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.service.IntelligentModule;
import com.example.helloworld.service.RetrieveMessageService;
import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

/**
 * Created by ccardona on 4/12/17.
 */

@Path("/getCoolStuff")
@Produces(MediaType.TEXT_PLAIN)
public class CoolStuffResource {

    private final RetrieveMessageService messageService;

    public CoolStuffResource() {
        Injector injector = Guice.createInjector(new IntelligentModule());
        messageService = injector.getInstance(RetrieveMessageService.class);
    }

    @GET
    @Timed
    public String sayHello(@QueryParam("option") Optional<Integer> option) {
        return doYourThing(option);
    }

    private String doYourThing(Optional<Integer> selectedOption) {
        if(!selectedOption.isPresent()) {
            return "That's not cool";
        } else {
            return messageService.getMyCoolMessage(selectedOption.get());
        }

    }
}