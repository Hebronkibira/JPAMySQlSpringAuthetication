package org.hebronworks.SpringAuthethicationJDBC;

import org.hebronworks.SpringAuthethicationJDBC.repo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringAuthethicationJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthethicationJdbcApplication.class, args);
	}

}
