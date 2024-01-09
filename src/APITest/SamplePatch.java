package APITest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;



public class SamplePatch {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		  Name name = new Name();
		  name.setName("*****Sample test Name*****");
		  ObjectMapper objectMapper = new ObjectMapper();
		  String requestBody = objectMapper.writeValueAsString(name);
			
		  HttpRequest request = HttpRequest.newBuilder().
		  uri(URI.create("https://api.restful-api.dev/objects/ff8081818cb48d30018cece389253c83")).
		  header("Content-Type", "application/json").
		  method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody)).
		  build();
		
	     HttpResponse<String> response = HttpClient.newHttpClient().
	     send(request, HttpResponse.BodyHandlers.ofString());

	     System.out.println(response.statusCode());
	     System.out.println(response.body());
	}

}
