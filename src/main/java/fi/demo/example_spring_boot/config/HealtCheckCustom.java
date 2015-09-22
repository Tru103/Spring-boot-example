package fi.demo.example_spring_boot.config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 
 * This is custom tailored spring-boot-starter-actuator {@link AbstractHealthIndicator}
 * Seems like that in Spring Boot parent 1.2.0 Release shows the full stack,
 * other versions 1.2.1 -> 1.2.6 no additional data is displayed withdetail method, bug?
 *
 */
@Component
public class HealtCheckCustom extends AbstractHealthIndicator  {

	/**
	 * Create call to localhost where one of the static rest calls can be made
	 * @return
	 */
	private int check() {
		
		String url = "http://localhost:8080/persons/2";
		int timeout = 2000;
		int responseCode = -1;
		
		// Otherwise an exception may be thrown on invalid SSL certificates:
		url = url.replaceFirst("^https", "http");
		    try {
		        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		        connection.setConnectTimeout(timeout);
		        connection.setReadTimeout(timeout);
		        connection.setRequestMethod("HEAD");
		        responseCode = connection.getResponseCode();
		        return responseCode;
		    } catch (IOException exception) {
		        return -1;
		    }
	}

	/**
	 * Create custom doHealthCheck method and then check if the error code exist
	 */
	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception {
		int errorCode = check();
		if (errorCode != -1) {
			if(errorCode >= 200 && errorCode <=399)
				builder.up().withDetail("Connection succesfull with:", errorCode).build();
			if(errorCode > 399)
				builder.down().withDetail("Error code:", errorCode);
		} else 
			builder.down().withDetail("errorCode", errorCode);
		
	}

}