package test.java;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class QuoteServiceTest {

	private static final String REST_URL = "http://localhost:8083/CitationApplication/api";

	/**
	 * Testing the Up Service
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ClientConfig config = new DefaultClientConfig();

		Client client = Client.create(config);

		WebResource service = client.resource(getBaseURI());
		System.out.println(service.path("quote").path("hugo").accept(MediaType.APPLICATION_JSON).get(String.class));
		System.out.println(service.path("quote").path("verlaine").accept(MediaType.APPLICATION_JSON).get(String.class));
		System.out.println(service.path("quote").path("fowler").accept(MediaType.APPLICATION_JSON).get(String.class));
	}

	/**
	 * Give the base URI
	 * 
	 * @return
	 */
	private static URI getBaseURI() {
		return UriBuilder.fromUri(REST_URL).build();
	}
}
