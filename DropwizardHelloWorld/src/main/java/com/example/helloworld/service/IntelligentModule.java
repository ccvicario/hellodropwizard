package com.example.helloworld.service;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Created by ccardona on 4/12/17.
 */
public class IntelligentModule implements Module {
    public void configure(Binder binder) {
        binder.bind(MessageGeneratorInterface.class).annotatedWith(One.class).to(MessageOne.class);
        binder.bind(MessageGeneratorInterface.class).annotatedWith(Two.class).to(MessageTwo.class);
    }
}
