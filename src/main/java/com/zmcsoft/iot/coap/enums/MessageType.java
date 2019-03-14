package com.zmcsoft.iot.coap.enums;

import com.zmcsoft.iot.coap.exception.CoapException;

/**
 * @author guyi
 */
public enum MessageType {

    Confirmable, NonConfirmable, Acknowledgement, Reset;

    public static MessageType valueOf(int transactionMessage) throws CoapException {
        switch (transactionMessage) {
            case 0:
                return Confirmable;
            case 1:
                return NonConfirmable;
            case 2:
                return Acknowledgement;
            case 3:
                return Reset;
            default:
                throw new CoapException("Message Code 解析错误");
        }
    }

    @Override
    public String toString() {
        return super.toString().substring(0, 3).toUpperCase();
    }

}
