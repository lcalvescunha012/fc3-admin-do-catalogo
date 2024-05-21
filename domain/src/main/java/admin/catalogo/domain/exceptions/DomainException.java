package admin.catalogo.domain.exceptions;

import admin.catalogo.domain.validation.Error;

import java.util.List;

public class DomainException extends NoStacktraceExeception {
    private final List<Error> errors;

    private DomainException(final String aMessagem, final List<Error> anErrors) {
        super(aMessagem);
        this.errors = anErrors;
    }

    public static DomainException with(final Error andErrors) {
        return new DomainException(andErrors.Message(), List.of(andErrors));
    }

    public static DomainException with(final List<Error> andErrors) {
        return new DomainException("", andErrors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
