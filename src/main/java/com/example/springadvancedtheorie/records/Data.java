package com.example.springadvancedtheorie.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Data(
        long id,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("email") String email
){}
