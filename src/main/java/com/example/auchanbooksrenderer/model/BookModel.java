package com.example.auchanbooksrenderer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class BookModel {

    @JsonProperty("title")
    private String bookName;
    @JsonProperty("authorName")
    private String authorName;

}
