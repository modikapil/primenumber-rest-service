package cucumber.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ws.rest.primenumber.model.PrimeNumberRequest;
import com.ws.rest.primenumber.model.PrimeNumberResponse;
import cucumber.BaseStep;
import io.cucumber.java8.En;
import org.junit.jupiter.api.Assertions;

public class PrimeNumberSteps extends BaseStep implements En {

    private String limit;
    private PrimeNumberRequest primeNumberRequest;
    private PrimeNumberResponse primeNumberResponse;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private String response;

    public PrimeNumberSteps() {

        Given("^a valid \"([^\"]*)\"$", (String limit) -> this.limit = limit);

        Given("^an invalid \"([^\"]*)\"$", (String limit) -> this.limit = limit);

        Given("^a valid prime number request$", () -> primeNumberRequest = new PrimeNumberRequest(limit));

        When("^prime number api is called$", () -> response = executePrimeNumber(primeNumberRequest));

        When("^prime number multithreaded api is called$", () -> response = executePrimeNumberMultithreaded(primeNumberRequest));

        Then("^a successful response is returned$",
                () -> {
                    try {
                        primeNumberResponse = objectMapper.readValue(response,
                                PrimeNumberResponse.class);
                    } catch (Exception e) {
                        throw new RuntimeException(
                                "Error during Step Definition");
                    }
                    Assertions.assertNotNull(primeNumberResponse);
                    Assertions.assertTrue(primeNumberResponse.getPrimeNumbers()
                            .size() > 0);
                });

        Then("^an unsuccessful response is returned$", () -> Assertions.assertTrue(response.contains("400")));

    }
}

