package com.example.helloworld.service;


import com.google.inject.Inject;

/**
 * Created by ccardona on 4/12/17.
 */
public class RetrieveMessageService {

    private MessageGeneratorInterface messageOne;
    private MessageGeneratorInterface messageTwo;

    @Inject
    public RetrieveMessageService(@One MessageGeneratorInterface messageOne, @Two MessageGeneratorInterface messageTwo) {
        this.messageOne = messageOne;
        this.messageTwo = messageTwo;
    }

    public String getMyCoolMessage(int messageToGet) {
        switch (messageToGet) {
            case 1:
                return messageOne.generateMessage();
            case 2:
                return messageTwo.generateMessage();
            default:
                return "I don't know about that but, cool.";
        }
    }
}
