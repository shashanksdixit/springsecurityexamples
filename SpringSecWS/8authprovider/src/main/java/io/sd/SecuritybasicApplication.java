package io.sd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("io.sd.persistance")
@EntityScan("io.sd.persistance")
public class SecuritybasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritybasicApplication.class, args);
	}

}
