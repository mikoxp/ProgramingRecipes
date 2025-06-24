package com.moles.elastic.person;

import lombok.Data;

@Data
public class PersonSearchCriteria {

    private String firstName;
    private String lastName;
    private Integer minAge;
    private Integer maxAge;
}
