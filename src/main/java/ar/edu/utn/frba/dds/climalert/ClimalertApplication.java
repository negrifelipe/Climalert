package ar.edu.utn.frba.dds.climalert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableScheduling
public class ClimalertApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClimalertApplication.class, args);
  }

}
