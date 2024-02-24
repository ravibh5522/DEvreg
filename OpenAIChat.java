import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class OpenAIChat {
    private static final String API_KEY = "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";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public String getOpenAIResponse(String userMessage) {
        // Set up the headers
        Map<Object, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + API_KEY);

        // Set up the request payload
       // String payload = "{\"prompt\": \"" + userMessage + "\"}";
        String model = "ft:gpt-3.5-turbo-1106:devrev-forge::8u4pYzIf";
        //create a json payload with the user message and the model

        //String payload = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + userMessage + "\"}]}";

        // Create the HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Create the HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Extract and return the assistant's message from the API response
            return response.body();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error getting response from OpenAI API.";
        }
    }
}
