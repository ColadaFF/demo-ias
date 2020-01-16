package com.example.demoias.serialization.adapters;

import com.example.demoias.domain.Ingreso;
import com.google.gson.*;

import java.lang.reflect.Type;

public class IngresoAdapter implements JsonDeserializer<Ingreso>, JsonSerializer<Ingreso> {

    @Override
    public Ingreso deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return Ingreso.of(json.getAsBigDecimal());
    }

    @Override
    public JsonElement serialize(Ingreso src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }
}
