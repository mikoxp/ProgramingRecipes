package com.moles.elastic.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "person")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @Id
    private String id;
    private String firstName;

    private String lastName;

    private int age;
}
