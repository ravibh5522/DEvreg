
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class re {

    public static void main(String[] args) throws Exception {
        // Replace "YOUR_API_KEY" with your OpenAI API key
        String apiKey = "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";

        // Replace "https://api.openai.com/v1/endpoint" with the appropriate API endpoint URL
        String apiUrl = "https://api.openai.com/v1/chat/completions";
  // Create an HttpClient
  HttpClient httpClient = HttpClient.newHttpClient();

  // Create a Map for your request payload (adjust accordingly based on the API requirements)
  Map<Object, Object> payload = new HashMap<>();
  payload.put("key", "value");

  // Convert the payload to a JSON string
  String jsonPayload = new ObjectMapper().writeValueAsString(payload);

  // Create an HttpRequest with the appropriate headers and POST method
  HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(apiUrl))
          .header("Content-Type", "application/json")
          .header("Authorization", "Bearer " + apiKey)
          .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
          .build();

  // Send the request and get the response
  HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

  // Print the response status code and body
  System.out.println("Response Code: " + response.statusCode());
  System.out.println("Response Body: " + response.body());
}
}