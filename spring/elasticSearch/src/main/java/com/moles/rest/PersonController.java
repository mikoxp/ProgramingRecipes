package com.moles.rest;

import com.moles.elastic.person.PersonDto;
import com.moles.elastic.person.PersonSearchCriteria;
import com.moles.elastic.person.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDto> getAll(){
        return personService.getAll();
    }

    @PostMapping
    public void add(@RequestBody PersonDto person){
        personService.add(person);
    }

    @PostMapping("/params")
    public List<PersonDto> getByParams(@RequestBody PersonSearchCriteria params){
        return personService.getByParams(params);
    }

}
