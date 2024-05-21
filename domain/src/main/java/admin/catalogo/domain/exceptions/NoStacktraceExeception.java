package admin.catalogo.domain.exceptions;

public class NoStacktraceExeception extends RuntimeException {

    public NoStacktraceExeception(final String message) {
        this(message, null);
    }

    public NoStacktraceExeception(String message, final Throwable cause) {
        super(message, cause, true, false);
    }
}
