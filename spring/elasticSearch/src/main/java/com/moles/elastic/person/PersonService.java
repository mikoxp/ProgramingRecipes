package com.moles.elastic.person;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    public static final String INDEX_NAME = "person";
    private final ElasticsearchClient elasticsearchClient;

    private final PersonMapper personMapper;

    public List<PersonDto> getAll(){
        try {
            SearchResponse<Person> response = elasticsearchClient.search(s -> s
                    .index(INDEX_NAME).query(q -> q.matchAll(m -> m)),Person.class);

            List<Person> collect = response.hits().hits().stream()
                    .map(hit -> hit.source())
                    .collect(Collectors.toList());
            return personMapper.toDtoList(collect);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(PersonDto dto){
        Person person = personMapper.toEntity(dto);
        if(person.getId()==null){
            person.setId(UUID.randomUUID().toString());
        }
        try{
            IndexResponse response = elasticsearchClient.index(i -> i
                    .index(INDEX_NAME)
                    .id(person.getId())
                    .document(person)
            );

            log.info("Add person with id '{}'",response.id());

        } catch (IOException e) {
            throw new RuntimeException("Indexing failed", e);
        }
    }
}
