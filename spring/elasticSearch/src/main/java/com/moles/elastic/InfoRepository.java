package com.moles.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;



public interface InfoRepository extends ElasticsearchRepository<Info, String> {
}
