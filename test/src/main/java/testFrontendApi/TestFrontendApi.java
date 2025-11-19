package testFrontendApi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.StoppeSted;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.ArrayList;

public class TestFrontendApi {

    @Test
    public void testGetStoppeSteder(){
        Response response = RestAssured.get("http://localhost:7000/stoppesteder");

        // Enkel sjekk av at endepunktet finnes
        response.then().assertThat().statusCode(200);

        // Henter ut json objectet i endepunktet og konvertere dette til en string
        String jsonResponse = response.then().extract().response().getBody().asString();

        // Try blokk med objektmapper som deserialisere json objetet til en arraylist med stoppested objekter som vi kjører tester på.
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<StoppeSted> stoppesteder = objectMapper.readValue(jsonResponse, new TypeReference<ArrayList<StoppeSted>>() {
            });
            Assertions.assertEquals("Moss", stoppesteder.getFirst().getName());
            Assertions.assertEquals("Rakkestad", stoppesteder.get(4).getName());
            Assertions.assertEquals("Svinesundparken", stoppesteder.getLast().getName());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetReiser(){
        Response response = RestAssured.get("http://localhost:7000/reisesok?start=Halden&stopp=Fredrikstad");
        Response response2 = RestAssured.get("http://localhost:7000/reisesok?start=Sarpsborg&stopp=Moss");

        // Enkel sjekk av at endepunktene finnes
        response.then().assertThat().statusCode(200);
        response.then().assertThat().statusCode(200);
    }
}
