package com.codexpro.Unipet.services.exceptions;

public class OrgAlreadyExistsException extends RuntimeException {
    public OrgAlreadyExistsException() {
        super("E-mail already exists.");
    }
}
