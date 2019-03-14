package org.jetlinks.coap.exception;

import org.jetlinks.coap.enums.Code;

/**
 * @author guyi
 */
public class CoapUnknownOptionException extends CoapCodeException {

    public CoapUnknownOptionException(int type) {
        super(Code.C402_BAD_OPTION, "Unknown option header: " + type);
    }
}
