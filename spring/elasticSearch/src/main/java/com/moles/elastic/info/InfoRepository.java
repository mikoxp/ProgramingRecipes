package com.moles.elastic.info;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;



public interface InfoRepository extends ElasticsearchRepository<Info, String> {
}
