package com.eduhub.eduhub_backend.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private final String resource;
    private final String field;
    private final String value;

    public ResourceNotFoundException(
            String resource,
            String field,
            String value) {

        super(String.format(
                "%s not found with %s : %s",
                resource,
                field,
                value
        ));

        this.resource = resource;
        this.field = field;
        this.value = value;
    }

    public String getResource() {
        return resource;
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }
}
