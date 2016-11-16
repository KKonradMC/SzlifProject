package com.polidea.konradkrakowiak.user.model;

public enum UserType {
    UNKNOWN, REGISTERED;

    interface Metadata {

        String REGISTERED = "REGISTERED";
    }
}
