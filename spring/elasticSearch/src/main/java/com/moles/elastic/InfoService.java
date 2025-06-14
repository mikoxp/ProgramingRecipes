package com.moles.elastic;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class InfoService {

    private final InfoRepository repository;

    public InfoService(InfoRepository repository) {
        this.repository = repository;
    }

    public Info add(Info info) {
        return repository.save(info);
    }

    public List<Info> getAll() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .toList();
    }
}
