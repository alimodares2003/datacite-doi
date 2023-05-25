package com.example.datacitedoi.model;

import java.util.List;

public record Client(String id, String type, String name, String created, List<String> prefixes) {
}
