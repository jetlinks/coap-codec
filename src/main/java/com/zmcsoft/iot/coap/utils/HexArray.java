package com.zmcsoft.iot.coap.utils;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author guyi
 */
public final class HexArray implements Serializable {

    private final static String HEX_DIGIT_STRING = "0123456789abcdef";
    private final static char[] HEX_DIGITS = HEX_DIGIT_STRING.toCharArray();
    private final byte[] data;

    public static String toHex(final byte[] data) {
        return data != null ? toHex(data, data.length) : null;
    }

    public static String toHex(final byte[] data, final int len) {
        final char[] retVal = new char[len * 2];
        int k = 0;
        for (int i = 0; i < len; i++) {
            retVal[k++] = HEX_DIGITS[(data[i] & 0xf0) >>> 4];
            retVal[k++] = HEX_DIGITS[data[i] & 0x0f];
        }
        return new String(retVal);
    }

    public static String toHexShort(final byte[] data, final int maxLen) {
        if (data.length <= maxLen) {
            return toHex(data, data.length);
        } else {
            return toHex(data, maxLen) + "..";
        }
    }

    public static byte[] fromHex(String hex) {
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            b[i / 2] = (byte) (HEX_DIGIT_STRING.indexOf(hex.charAt(i)) * 16 + HEX_DIGIT_STRING.indexOf(hex.charAt(i + 1)));
        }

        return b;
    }

    public HexArray(byte... data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return toHex(data, data.length);
    }

    public byte[] getData() {
        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HexArray other = (HexArray) obj;
        if (!Arrays.equals(getData(), other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Arrays.hashCode(this.data);
        return hash;
    }

}
