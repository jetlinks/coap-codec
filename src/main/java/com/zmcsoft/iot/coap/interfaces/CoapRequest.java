package com.zmcsoft.iot.coap.interfaces;

import com.zmcsoft.iot.coap.CoapPacket;
import com.zmcsoft.iot.coap.enums.Code;
import com.zmcsoft.iot.coap.enums.Method;
import com.zmcsoft.iot.coap.exception.CoapException;
import com.zmcsoft.iot.coap.interfaces.impl.CoapRequestImpl;
import com.zmcsoft.iot.coap.options.HeaderOptions;
import io.netty.buffer.ByteBuf;

/**
 * @author guyi
 * @since 1.0.0.0
 */
public interface CoapRequest {

    CoapPacket getPacket();

    Method getMethod();

    int getMessageId();

    byte[] getPayload();
    String getPayloadString();

    byte[] getToken();

    Code getCode();

    HeaderOptions headers();

    static CoapRequest from(ByteBuf buf) throws CoapException {
        return new CoapRequestImpl(CoapPacket.read(null,buf.array()));
    }

    default CoapResponse createResponse(){
        return CoapResponse.from(this);
    }
    default CoapResponse createResponse(Code code){
        return CoapResponse.from(this,code);
    }

}
