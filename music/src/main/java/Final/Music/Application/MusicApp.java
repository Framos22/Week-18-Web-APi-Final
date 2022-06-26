package Final.Music.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"Final.Music.controller", "Final.Music.exception", "Final.Music.model", "Final.Music.repository",
    "Final.Music.service", "Final.Music.service.impl"})
@EntityScan("Final.Music.model")
@EnableJpaRepositories(basePackages = "Final.Music.repository")
public class MusicApp {
  
  public static void main(String[] args) {
        SpringApplication.run(MusicApp.class, args);
        
    }
  

}
