package com.polidea.konradkrakowiak.user.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class UserTypeDeserializer implements JsonDeserializer<UserType> {

    @Override
    public UserType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        switch(json.getAsString()){
            case UserType.Metadata.REGISTERED:
                return UserType.REGISTERED;
            default:
                return UserType.UNKNOWN;
        }
    }
}
