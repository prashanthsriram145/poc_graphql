package com.prashanth.poc.graphql.client;

import com.prashanth.poc.graphql.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GraphqlClient {
    @Autowired
    private RestTemplate restTemplate;

    String query = "query bookDetails {\n" +
            "  bookByName(name: \"Moby Dick\") {\n" +
            "    id\n" +
            "    name\n" +
            "    pageCount\n" +
            "    author {\n" +
            "      id\n" +
            "      firstName\n" +
            "      lastName\n" +
            "    }\n" +
            "  }\n" +
            "}";

    @Scheduled(cron = "0 */1 * ? * *")
    private void invokeGraphqlApi() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/graphql");
        String url = "http://localhost:8080/graphiql?path=/graphql";

        ResponseEntity<Book> response = restTemplate.postForEntity(url, new HttpEntity<>(query, headers), Book.class);
        System.out.println("Book : " + response.getBody());
    }


}
