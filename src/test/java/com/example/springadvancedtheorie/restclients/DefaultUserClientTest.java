package com.example.springadvancedtheorie.restclients;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DefaultUserClientTest {
    private final DefaultUserClient client;

    DefaultUserClientTest(DefaultUserClient client) {
        this.client = client;
    }

    @Test
    void findById() {
        assertThat(client.findById(1)).hasValueSatisfying(user -> {
            assertThat(user.data().id()).isOne();
            assertThat(user.data().email()).isEqualTo("george.bluth@reqres.in");
        });
    }
    @Test
    void findByWrongId() {
        assertThat(client.findById(-1)).isEmpty();

    }
}