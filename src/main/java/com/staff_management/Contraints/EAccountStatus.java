package com.staff_management.Contraints;

public enum EAccountStatus {
    ACTIVE("ACTIVE","Current account is active"),
    LOCK("LOCKED", "Current account is locked"),
    DELETE("DELETED", "Current account is disabled"),
    TEMP_LOCKED("TEMP_LOCKED", "Current account is temporary locked");
    private   final String VALUE;
    private  final String DESCRIPTION;
    private EAccountStatus(String values, String des) {
        this.VALUE = values;
        this.DESCRIPTION= des;
    }
}
