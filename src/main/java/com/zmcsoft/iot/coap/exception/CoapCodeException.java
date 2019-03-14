package com.zmcsoft.iot.coap.exception;

import com.zmcsoft.iot.coap.enums.Code;

/**
 * @author guyi
 */
public class CoapCodeException extends CoapException {

    private final Code code;

    public CoapCodeException(Code code) {
        super(code.toString().substring(1).replace("_", " "));
        this.code = code;
    }

    public CoapCodeException(Code code, Throwable throwable) {
        super(code.toString().substring(1).replace("_", " "), throwable);
        this.code = code;
    }

    public CoapCodeException(Code code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * @return the code
     */
    public Code getCode() {
        return code;
    }

}
