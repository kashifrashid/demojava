package d.kash.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * A console application that prints a greeting using a configured value.
 * Spring Boot sets up Spring and finds components in this package and its subpackages.
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * Registers a startup task with Spring. Spring calls the returned runner after
	 * the application context (the container holding managed objects) is ready.
	 *
	 * @param greeterLocation the required greeter.location property, normally read
	 *                        from application.properties
	 * @return a startup task that prints the greeting once
	 */
	@Bean
	public CommandLineRunner cmdRunner(@Value("${greeter.location}") String greeterLocation) {
		// The lambda implements CommandLineRunner.run; its args are command-line arguments.
		return args -> System.out.println("Hi " + greeterLocation);
	}

	/**
	 * Java starts here; SpringApplication then loads configuration and runs startup tasks.
	 *
	 * @param args command-line arguments, including optional Spring property overrides
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
