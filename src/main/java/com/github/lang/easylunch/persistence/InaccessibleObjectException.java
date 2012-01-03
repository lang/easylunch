package com.github.lang.easylunch.persistence;

public class InaccessibleObjectException extends RuntimeException {

    private String objectDescription;

    public InaccessibleObjectException(String objectDescription) {
        this.objectDescription = objectDescription;
    }

    @Override
    public String getMessage() {
        return "object " + objectDescription + " doesn't exist " +
            "or can't be accessed by current user";
    }

}
