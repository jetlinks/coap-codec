package com.zmcsoft.iot.coap.utils;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author guyi
 */
public class PacketUtils {

    public static byte[] readN(StrictInputStream is, int bytesCount, boolean orBlock) throws IOException {
        assertEnoughData(is, bytesCount, orBlock);
        return is.readBytes(bytesCount);
    }


    public static long read32(InputStream is, boolean orBlock) throws IOException {
        assertEnoughData(is, 4, orBlock);
        long ret = is.read() << 24;
        ret |= is.read() << 16;
        ret |= is.read() << 8;
        ret |= is.read();

        return ret;
    }

    public static int read16(InputStream is, boolean orBlock) throws IOException {
        assertEnoughData(is, 2, orBlock);
        int ret = is.read() << 8;
        ret |= is.read();
        return ret;
    }

    public static int read8(InputStream is, boolean orBlock) throws IOException {
        assertEnoughData(is, 1, orBlock);
        return is.read();
    }

    private static void assertEnoughData(InputStream is, int expectedMinimum, boolean orBlock) throws IOException {
        if (orBlock) {
            return;
        }
        if (is.available() < expectedMinimum) {
            throw new NotEnoughDataException();
        }
    }

    public static class NotEnoughDataException extends IOException {
    }

    public static void write8(OutputStream os, int data) throws IOException {
        os.write(data);
    }

    public static void write16(OutputStream os, int data) throws IOException {
        os.write((data >> 8) & 0xFF);
        os.write((data >> 0) & 0xFF);
    }

    public static void write32(OutputStream os, long data) throws IOException {
        os.write((int) ((data >> 24) & 0xFF));
        os.write((int) ((data >> 16) & 0xFF));
        os.write((int) ((data >> 8) & 0xFF));
        os.write((int) ((data >> 0) & 0xFF));
    }
}
