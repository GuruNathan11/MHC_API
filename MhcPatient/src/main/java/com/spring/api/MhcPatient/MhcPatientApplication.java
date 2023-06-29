package com.spring.api.MhcPatient;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//
//@SpringBootApplication
//
//public class MhcPatientApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(MhcPatientApplication.class, args);
//    }
//}
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = MailSenderAutoConfiguration.class)
public class MhcPatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MhcPatientApplication.class, args);
    }

}
