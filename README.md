# coap-codec
coap编解码器
[![Maven Central](https://img.shields.io/maven-central/v/org.jetlinks/coap-codec.svg)](http://search.maven.org/#search%7Cga%7C1%7Ccoap-codec)

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