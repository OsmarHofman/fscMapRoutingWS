package br.edu.ifsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MapeamentoIfscApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapeamentoIfscApplication.class, args);
	}

}
