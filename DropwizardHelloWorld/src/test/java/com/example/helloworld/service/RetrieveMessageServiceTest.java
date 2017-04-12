package com.example.helloworld.service;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ccardona on 4/12/17.
 */
public class RetrieveMessageServiceTest {

    final static Logger log = LoggerFactory.getLogger(RetrieveMessageServiceTest.class);

    private RetrieveMessageService messageService;
    private static final String MESSAGE_ONE = "Testing one";
    private static final String MESSAGE_TWO = "Testing two";

    @Before
    public void init() {
        MessageGeneratorInterface mockitoOne = Mockito.mock(MessageOne.class);
        Mockito.when(mockitoOne.generateMessage()).thenReturn(MESSAGE_ONE);
        MessageGeneratorInterface mockitoTwo = Mockito.mock(MessageTwo.class);
        Mockito.when(mockitoTwo.generateMessage()).thenReturn(MESSAGE_TWO);
        messageService = new RetrieveMessageService(mockitoOne, mockitoTwo);
    }

    @Test
    public void testGetMyCoolMessage() {
        log.info("Starting test testGetMyCoolMessage");
        Assert.assertTrue(messageService.getMyCoolMessage(1).equals(MESSAGE_ONE));
        Assert.assertTrue(messageService.getMyCoolMessage(2).equals(MESSAGE_TWO));
        Assert.assertFalse(messageService.getMyCoolMessage(3).equals(MESSAGE_ONE));
        Assert.assertFalse(messageService.getMyCoolMessage(3).equals(MESSAGE_TWO));
        log.info("Finished test testGetMyCoolMessage");
    }
}
