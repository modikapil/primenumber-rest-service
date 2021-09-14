package cucumber;

import com.ws.rest.primenumber.model.PrimeNumberRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class BaseStep {

    private final HttpClient client;

    public BaseStep() {
        client = HttpClientBuilder.create().build();
    }

    public String executePrimeNumber(PrimeNumberRequest primeNumberRequest) {
        String primeNumberResource = "http://localhost:8080/v1/calculator/primeNumbers/%s";
        HttpGet request = new HttpGet(String.format(primeNumberResource,
                primeNumberRequest.getPrimeNumberLimit()));
        String json;
        try {
            HttpResponse response = client.execute(request);
            json = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException("Error during Step Definition");
        }
        return json;
    }

    public String executePrimeNumberMultithreaded(
            PrimeNumberRequest primeNumberRequest) {
        String primeNumberMultiThreadedResource = "http://localhost:8080/v1/calculator/primeNumbers/multiThreaded/%s";
        HttpGet request = new HttpGet(String.format(
                primeNumberMultiThreadedResource,
                primeNumberRequest.getPrimeNumberLimit()));
        String json;
        try {
            HttpResponse response = client.execute(request);
            json = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException("Error during Step Definition");
        }
        return json;
    }

}

