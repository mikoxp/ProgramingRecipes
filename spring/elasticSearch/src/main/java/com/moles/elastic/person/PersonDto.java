package com.moles.elastic.person;

public record PersonDto(
        String id,
        String firstName,
        String lastName,
        int age
) {}
