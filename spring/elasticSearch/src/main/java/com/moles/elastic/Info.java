package com.moles.elastic;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "info")
public class Info {
    @Id
    private String id;
    private String message;
}
