package com.hanulhan.tpvWebService;

import com.hanulhan.tpvWebService.service.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com.hanulhan"})
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class TpvWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpvWebServiceApplication.class, args);
    }

}
