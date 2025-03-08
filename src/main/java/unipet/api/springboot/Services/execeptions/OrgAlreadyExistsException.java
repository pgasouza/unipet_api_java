package unipet.api.springboot.Services.Execeptions;

public class OrgAlreadyExistsException extends RuntimeException {
    public OrgAlreadyExistsException() {
        super("E-mail already exists.");
 }
}