package com.example.springadvancedtheorie.restclients;

import com.example.springadvancedtheorie.records.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Optional;

@Component
public class DefaultUserClient implements UserClient {
    private final WebClient webClient;
    private final String userUri;

    public DefaultUserClient(WebClient.Builder webClient, @Value("${reqres.user}") String userUri) {
        this.webClient = webClient.build();
        this.userUri = userUri;
    }

    @Override
    public Optional<User> findById(long id) {
        try{
           return Optional.of(webClient.get()
                    .uri(userUri, uriBuilder -> uriBuilder.build(id))
                    .retrieve().bodyToMono(User.class).block()
           );
        } catch (WebClientResponseException e) {
            return Optional.empty();
        }
    }
}
