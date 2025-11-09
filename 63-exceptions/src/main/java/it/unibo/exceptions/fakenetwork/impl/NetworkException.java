package it.unibo.exceptions.fakenetwork.impl;

import java.util.Objects;
import java.io.IOException;

public class NetworkException extends IOException{
    public NetworkException (){
        super("Network error: no response");
    }

    public NetworkException(final String message){
        super(Control(message));

    }

    public static String Control(final String message){
        Objects.requireNonNull(message);
        return "Network error while sending message: " + message;

    }
}
