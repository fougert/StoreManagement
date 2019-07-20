package com.rehoshi.model;

import java.util.UUID;

public abstract class BaseModel {
    public abstract void setId(String id) ;
    public abstract String getId() ;
    public void newId(){
        setId(generateUUID());
    }

    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
