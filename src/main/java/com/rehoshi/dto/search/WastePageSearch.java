package com.rehoshi.dto.search;

public class WastePageSearch extends PageSearch{
    private String name;

    public String getName() {
        if (name == null) {
            name = "";
        }
        return "%" + name + "%";
    }

    public void setName(String name) {
        this.name = name;
    }
}
