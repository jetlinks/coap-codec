package org.jetlinks.coap.exception;

/**
 * @author guyi
 */
public class CoapException extends RuntimeException {

    public CoapException(Throwable cause) {
        super(cause);
    }

    public CoapException(String message) {
        super(message);
    }

    public CoapException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoapException(String format, Object... args) {
        super(String.format(format, args));
    }
}
