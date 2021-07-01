/**
 * @author Mohamad Chaman-Motlagh m.chamanmotlagh[at]gmail.com
 * This is the Main class that starts the Spring-boot application
 * */
package ir.mohamadcm.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

}
