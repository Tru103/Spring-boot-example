package fi.demo.example_spring_boot.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

/**
 * 
 * Expose all actuator endpoints at http://localhost:8080/Endpoints
 *
 */
@SuppressWarnings("rawtypes")
@Component
public class Endpoints extends AbstractEndpoint<List<Endpoint>>{

	//List of all endpoints
	private List<Endpoint> endpointsList;

	/**
	 * Autowire and create acces by url /Endpoints
	 * @param listOfEndpoints
	 */
    @Autowired
    public Endpoints(List<Endpoint> listOfEndpoints) {
        super("Endpoints");
        this.endpointsList = listOfEndpoints;
    }

    public List<Endpoint> invoke() {
        return this.endpointsList;
    }
}
