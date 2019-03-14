package com.zmcsoft.iot.coap.enums;

import com.zmcsoft.iot.coap.exception.CoapException;

/**
 * @author guyi
 */
public enum Method {

    GET, POST, PUT, DELETE;

    public static Method valueOf(int methodCode) throws CoapException {
        switch (methodCode) {
            case 1:
                return GET;
            case 2:
                return POST;
            case 3:
                return PUT;
            case 4:
                return DELETE;
            default:
                throw new CoapException("Method Code 解析错误");
        }
    }

    public int getCode() {
        return this.ordinal() + 1;
    }
}
