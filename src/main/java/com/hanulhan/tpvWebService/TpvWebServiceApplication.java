package com.hanulhan.tpvWebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com.hanulhan"})
public class TpvWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpvWebServiceApplication.class, args);
    }

}
