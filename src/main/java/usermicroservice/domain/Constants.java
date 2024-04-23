package usermicroservice.domain;

public class Constants {
    private Constants(){
        throw new IllegalStateException("utility class");
    }

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_TUTOR = "TUTOR";
    public static final String ROLE_STUDENT = "STUDENT";

    public static final String ID_ROL_VALIDATIONS_EXCEPTION_MESSAGE = "the role %s was not found";
    public static final String EMAIL_EXCEPTION_MESSAGE = "the email is already registered";
    public static final String INVALID_CREDENTIALS = "invalid credential: %s";
}
