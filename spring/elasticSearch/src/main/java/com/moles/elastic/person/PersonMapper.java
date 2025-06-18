package com.moles.elastic.person;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto toDto(Person person);

    Person toEntity(PersonDto dto);

    List<PersonDto> toDtoList(List<Person> people);
    List<Person> toEntityList(List<PersonDto> dtoList);
}
