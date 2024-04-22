package usermicroservice.domain;

public class Constants {
    private Constants(){
        throw new IllegalStateException("utility class");
    }
    public static final String ID_ROL_VALIDATIONS_EXCEPTION_MESSAGE = "the role with the id %d was not found";
    public static final String EMAIL_EXCEPTION_MESSAGE = "the email is already registered";
    public static final String INVALID_CREDENTIALS = "invalid credential: %s";
}
