package com.tado
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class DevOpsDemoApplication {

   public static void main(String[] args) {
      SpringApplication.run(DevOpsDemoApplication, args)
   }

}
