package com.rehoshi.model;

import java.util.UUID;

public abstract class BaseModel {

    private String id;

    private String creatorId ;
    private User creator ;

    private String updaterId ;
    private User updater ;


    public void setId(String id) {
        this.id = id;

    }

    public String getId() {
        return this.id;
    }

    public void newId() {
        setId(generateUUID());
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getUpdater() {
        return updater;
    }

    public void setUpdater(User updater) {
        this.updater = updater;
    }
}
