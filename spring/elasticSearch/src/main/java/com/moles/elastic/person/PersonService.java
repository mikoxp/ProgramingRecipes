package com.moles.elastic.person;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.util.ObjectBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    public static final String INDEX_NAME = "person";
    private final ElasticsearchClient elasticsearchClient;

    private final PersonMapper personMapper;
    private final Function<RangeQuery.Builder, ObjectBuilder<RangeQuery>> builderObjectBuilderFunction = r -> r;

    public List<PersonDto> getAll() {
        try {
            SearchResponse<Person> response = elasticsearchClient.search(s -> s
                    .index(INDEX_NAME).query(q -> q.matchAll(m -> m)), Person.class);

            return getPersonDtos(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<PersonDto> getPersonDtos(SearchResponse<Person> response) {
        List<Person> collect = response.hits().hits().stream()
                .map(hit -> hit.source())
                .collect(Collectors.toList());
        return personMapper.toDtoList(collect);
    }

    public void add(PersonDto dto) {
        Person person = personMapper.toEntity(dto);
        if (person.getId() == null) {
            person.setId(UUID.randomUUID().toString());
        }
        try {
            IndexResponse response = elasticsearchClient.index(i -> i
                    .index(INDEX_NAME)
                    .id(person.getId())
                    .document(person)
            );

            log.info("Add person with id '{}'", response.id());

        } catch (IOException e) {
            throw new RuntimeException("Indexing failed", e);
        }
    }

    public List<PersonDto> getByParams(PersonSearchCriteria params) {
        try {
            List<Query> filter = getFilter(params);
            SearchResponse<Person> response = elasticsearchClient.search(s -> s
                    .index(INDEX_NAME).query(q -> q.bool(b -> b.must(filter))), Person.class);

            return getPersonDtos(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Query> getFilter(PersonSearchCriteria criteria) {
        List<Query> queries = new ArrayList<>();
        if (criteria == null) {
            return queries;
        }
        if (criteria.getFirstName() != null && !criteria.getFirstName().isBlank()) {
//            match
//            queries.add(Query.of(q -> q
//                    .match(m -> m
//                            .field("firstName")
//                            .query(criteria.getFirstName())
//                    )));
            queries.add(Query.of(q -> q
                    .wildcard(w -> w
                            .field("firstName")
                            .wildcard("*" + criteria.getFirstName().toLowerCase() + "*")
                            .caseInsensitive(true) // ignore char size
                    )
            ));
        }

        if (criteria.getLastName() != null && !criteria.getLastName().isBlank()) {
            queries.add(Query.of(q -> q
                    .wildcard(w -> w
                            .field("lastName")
                            .wildcard("*" + criteria.getLastName().toLowerCase() + "*")
                            .caseInsensitive(true) // ignore char size
                    )
            ));
        }
        if (criteria.getMaxAge() != null || criteria.getMinAge() != null) {
            queries.add(Query.of(q -> q.range(r -> {
                r.field("age");

                if (criteria.getMinAge() != null) {
                    r.gte(JsonData.of(criteria.getMinAge()));
                }
                if (criteria.getMaxAge() != null) {
                    r.lte(JsonData.of(criteria.getMaxAge()));
                }

                return r;
            })));
        }

        return queries;
    }
}
