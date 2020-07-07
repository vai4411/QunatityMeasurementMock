package com.bl.quantitymeasurement.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum  BaseUnit {
    Length,Weight,Volume,Temperature;

    @JsonCreator
    public static BaseUnit fromString(String key) {
        for(BaseUnit type : BaseUnit.values()) {
            if(type.name().equalsIgnoreCase(key)) {
                return type;
            }
        }
        return null;
    }
}
