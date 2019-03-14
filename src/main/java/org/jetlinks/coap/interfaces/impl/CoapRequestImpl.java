package org.jetlinks.coap.interfaces.impl;

import org.jetlinks.coap.CoapPacket;
import org.jetlinks.coap.enums.Code;
import org.jetlinks.coap.enums.Method;
import org.jetlinks.coap.interfaces.CoapRequest;
import org.jetlinks.coap.options.HeaderOptions;
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
