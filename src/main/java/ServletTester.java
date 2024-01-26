import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class ServletTester {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Créez le client HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construisez la requête
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/matchs-infos/equipes"))
                .GET() // GET est la méthode par défaut, mais c'est explicite ici
                .build();

        // Envoyez la requête et obtenez une réponse
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Affichez le statut de la réponse
        System.out.println("Status Code: " + response.statusCode());

        // Affichez le corps de la réponse
        System.out.println("Response Body: " + response.body());
    }
}
