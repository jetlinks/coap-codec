package com.zmcsoft.iot.coap.exception;

import com.zmcsoft.iot.coap.enums.Code;

/**
 * @author guyi
 */
public class CoapUnknownOptionException extends CoapCodeException {

    public CoapUnknownOptionException(int type) {
        super(Code.C402_BAD_OPTION, "Unknown option header: " + type);
    }
}
