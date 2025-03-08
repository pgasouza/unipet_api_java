package unipet.api.springboot.Services.execeptions;

public class OrgAlreadyExistsException extends RuntimeException {
    public OrgAlreadyExistsException() {
        super("E-mail already exists.");
 }
}