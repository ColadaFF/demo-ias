package com.example.demoias.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class Account {
    @NonNull
    private final List<Ingreso> values;
    private final String name;
    private final String id;
    private final String type;
    private final String anotherOne;
}
