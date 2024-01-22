package com.example.twiliocall;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;

@SpringBootApplication
public class TwilioCallApplication implements ApplicationRunner {

    private final static String SID_ACCOUNT = "AC7422e6391ae0f8777789915d9efb5dfd";
    private final static String AUTH_ID = "8d525377f1ffbc5dfd144a5da68bc04e";
    private final static String FROM_NUMBER="+16592242983";
    private final static String TO_NUMBER ="+917999573249";

    static {
        Twilio.init(SID_ACCOUNT, AUTH_ID);
    }
    public static void main(String[] args) {
        SpringApplication.run(TwilioCallApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
                new URI("http://demo.twilio.com/docs/voice.xml")).create();
    }
}
