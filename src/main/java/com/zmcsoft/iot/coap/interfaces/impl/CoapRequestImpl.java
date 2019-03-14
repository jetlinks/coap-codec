package com.zmcsoft.iot.coap.interfaces.impl;

import com.zmcsoft.iot.coap.CoapPacket;
import com.zmcsoft.iot.coap.enums.Code;
import com.zmcsoft.iot.coap.enums.Method;
import com.zmcsoft.iot.coap.interfaces.CoapRequest;
import com.zmcsoft.iot.coap.options.HeaderOptions;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author guyi
 * @since 1.0.0.0
 */
@AllArgsConstructor
public class CoapRequestImpl implements CoapRequest {

    @Getter
    private CoapPacket packet;

    @Override
    public Method getMethod() {
        return this.packet.getMethod();
    }

    @Override
    public int getMessageId() {
        return this.packet.getMessageId();
    }

    @Override
    public byte[] getPayload() {
        return this.packet.getPayload();
    }

    @Override
    public String getPayloadString() {
        return this.packet.getPayloadString();
    }

    @Override
    public byte[] getToken() {
        return this.getToken();
    }

    @Override
    public Code getCode() {
        return this.getCode();
    }

    @Override
    public HeaderOptions headers() {
        return this.packet.headers();
    }

}
