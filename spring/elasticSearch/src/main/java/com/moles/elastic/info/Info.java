package com.moles.elastic.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "info")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
    @Id
    private String id;
    private String message;
}
