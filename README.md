# coap-codec
coap编解码器

```java
//encode
CoapPacket coapPacket = new CoapPacket();
coapPacket.setCode(Code.C205_CONTENT);
coapPacket.setPayload("{}");
coapPacket.headers().setContentFormat(MediaTypes.CT_TEXT_PLAIN);

coapPacket.writeTo(outputStream);


//decode
 CoapPacket packet = CoapPacket.deserialize(inputStream);
 
 packet.headers();
 
 packet.getPayloadString();


```