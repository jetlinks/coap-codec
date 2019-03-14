package com.zmcsoft.iot.coap.interfaces.impl;

import com.zmcsoft.iot.coap.CoapPacket;
import com.zmcsoft.iot.coap.enums.Code;
import com.zmcsoft.iot.coap.interfaces.CoapResponse;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.Getter;

/**
 * @author guyi
 * @since 1.0.0.0
 */
public class CoapResponseImpl implements CoapResponse {

    @Getter
    private CoapPacket packet;
    public CoapResponseImpl(CoapPacket packet,Code code){
        this.packet = packet.createResponse(code);
    }

    @Override
    public ByteBuf toByteBuf() {
        return Unpooled.copiedBuffer(this.toByteArray());
    }

    @Override
    public byte[] toByteArray() {
        return this.packet.toByteArray();
    }

    @Override
    public void setPayload(byte[] payload) {
        this.packet.setPayload(payload);
    }

    @Override
    public void putHeader(int optionNumber, byte[] data, Code code) {
        this.packet.headers().put(optionNumber,data,code);
    }
}
