package com.example.demoias.serialization.adapters;

import com.example.demoias.domain.Account;
import com.example.demoias.domain.Ingreso;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountAdapter implements JsonDeserializer<Account>, JsonSerializer<Account> {
    private final Type listIngresos = new TypeToken<List<Ingreso>>() {
    }.getType();
    @Override
    public Account deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject rootObject = json.getAsJsonObject();
        JsonElement ingresos = rootObject.get("ingresos");

        List<Ingreso> deserialize = context.deserialize(ingresos, listIngresos);

        String id = Optional.ofNullable(rootObject.get("id"))
                .map(JsonElement::getAsString)
                .orElse(null);

        return Account.builder()
                .values(deserialize)
                .id(id)
                .build();
    }

    @Override
    public JsonElement serialize(Account src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        JsonElement serialize = context.serialize(src.getValues(), listIngresos);
        object.add("ingresos", serialize);
        object.addProperty("name", src.getName());
        object.addProperty("id", src.getId());
        return object;
    }
}
