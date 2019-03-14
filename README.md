# coap-codec
coap编解码器

### CoapRequest
Coap请求包装
#### 创建
``` java
CoapRequest.from(ByteBuf buf)
```
从ByteBuf中创建请求包装

### CoapResponse
Coap响应包装
#### 创建
``` java
CoapRequest.createResponse()
CoapRequest.createResponse(Code code)
CoapResponse.from(CoapRequest request)
CoapResponse.from(CoapRequest request,Code code)
```