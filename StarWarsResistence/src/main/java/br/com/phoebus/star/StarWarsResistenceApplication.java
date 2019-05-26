package br.com.phoebus.star;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = { "br.com.phoebus.star.entidades" })
@EnableJpaRepositories(basePackages = { "br.com.phoebus.star.repositorios" })
@ComponentScan(basePackages = {"br.com.phoebus.star.ws"})
public class StarWarsResistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsResistenceApplication.class, args);
	}

}
