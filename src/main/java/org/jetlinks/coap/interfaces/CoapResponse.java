package org.jetlinks.coap.interfaces;

import org.jetlinks.coap.enums.Code;
import org.jetlinks.coap.interfaces.impl.CoapResponseImpl;
import io.netty.buffer.ByteBuf;

public interface CoapResponse {

    ByteBuf toByteBuf();

    byte[] toByteArray();

    void setPayload(byte[] payload);

    void putHeader(int optionNumber, byte[] data, Code code);

    static CoapResponse from(CoapRequest request, Code code){
        return new CoapResponseImpl(request.getPacket(),code);
    }

    static CoapResponse from(CoapRequest request){
        return from(request,Code.C205_CONTENT);
    }

}
