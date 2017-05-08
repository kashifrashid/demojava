package d.kash.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	@Bean
	public CommandLineRunner cmdRunner(@Value("${greeter.location") String greeterLocation) {
		return args -> System.out.println("Hi " +  greeterLocation);

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
