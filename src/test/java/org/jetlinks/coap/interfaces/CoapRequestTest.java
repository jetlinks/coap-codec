package org.jetlinks.coap.interfaces;

import lombok.SneakyThrows;
import org.jetlinks.coap.CoapPacket;
import org.jetlinks.coap.enums.Code;
import org.jetlinks.coap.enums.MediaTypes;
import org.jetlinks.coap.enums.MessageType;
import org.jetlinks.coap.enums.Method;
import org.jetlinks.coap.options.BasicHeaderOptions;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

/**
 * @author zhouhao
 * @since 1.0.0
 */
public class CoapRequestTest {


    @Test
    @SneakyThrows
    public void test() {
        CoapPacket coapPacket = new CoapPacket(null);
        coapPacket.setCode(Code.C205_CONTENT);
        coapPacket.setPayload("123");
        coapPacket.headers().setContentFormat(MediaTypes.CT_TEXT_PLAIN);
        String dataString = coapPacket.toString(true, false, false, false);

        System.out.println(dataString);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        coapPacket.writeTo(outputStream);

        CoapPacket packet = CoapPacket.deserialize(null, new ByteArrayInputStream(outputStream.toByteArray()));

        Assert.assertEquals(packet.headers().getContentFormat().shortValue(), MediaTypes.CT_TEXT_PLAIN);
        Assert.assertEquals(packet.getPayloadString(), "123");
        String dataString2 = coapPacket.toString(true, false, false, false);

        System.out.println(coapPacket.toString(true, false, false, false));

        Assert.assertEquals(dataString, dataString2);
    }
}