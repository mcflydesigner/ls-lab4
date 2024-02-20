package org.innopolis.demoapp.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloDto {
    @JsonProperty("text")
    private String text;

    public HelloDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
