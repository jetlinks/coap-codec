package com.zmcsoft.iot.coap.utils;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author guyi
 */
public class StrictInputStream extends InputStream {
    private final InputStream inputStream;

    public StrictInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public byte[] readBytes(int len) throws IOException {
        byte[] bytes = new byte[len];
        int totalRead = 0;

        //loop until all data is read or EOF
        while (totalRead < len) {
            int r = inputStream.read(bytes, totalRead, len - totalRead);
            if (r == -1) {
                throw new EOFException();
            }
            totalRead += r;
        }
        return bytes;
    }

    @Override
    public int read() throws IOException {
        int val = inputStream.read();
        if (val < 0) {
            throw new EOFException();
        }
        return val;
    }

    @Override
    public int available() throws IOException {
        return inputStream.available();
    }
}
