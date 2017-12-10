package de.hartmut.jfs.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hartmut on 13.02.16.
 */
@SpringBootApplication
public class CloudLightApplication {

   public static void main(String[] args) throws Exception {
        SpringApplication.run(CloudLightApplication.class, args);
    }

}
