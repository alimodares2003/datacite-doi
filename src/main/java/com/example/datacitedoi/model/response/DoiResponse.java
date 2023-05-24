package com.example.datacitedoi.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DoiResponse(@JsonProperty("total_doi") Long totalDoi) {
}
