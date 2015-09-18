package fi.demo.example_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * 	This runs the whole spring application with default configuration.
 *	It also targers the default application.properties file
 *
 *	Access as localhost:8080
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App 
{
	/**
	 * Run as java application
	 * 
	 * @param args
	 */
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
