package com.moles.elastic.info;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class InfoService {

    private final ElasticsearchClient elasticsearchClient;

    private final InfoRepository repository;

    public Info add(Info info) {
        return repository.save(info);
    }

    public List<Info> getAll() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .toList();
    }

}
