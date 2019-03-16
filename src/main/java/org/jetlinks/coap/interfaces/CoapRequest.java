package org.jetlinks.coap.interfaces;

import io.netty.buffer.ByteBufInputStream;
import org.jetlinks.coap.CoapPacket;
import org.jetlinks.coap.enums.Code;
import org.jetlinks.coap.enums.Method;
import org.jetlinks.coap.exception.CoapException;
import org.jetlinks.coap.interfaces.impl.CoapRequestImpl;
import org.jetlinks.coap.options.HeaderOptions;
import io.netty.buffer.ByteBuf;

import java.net.InetSocketAddress;

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
        return new CoapRequestImpl(CoapPacket.deserialize(new ByteBufInputStream(buf)));
    }


    default CoapResponse createResponse() {
        return CoapResponse.from(this);
    }

    default CoapResponse createResponse(Code code) {
        return CoapResponse.from(this, code);
    }

}
