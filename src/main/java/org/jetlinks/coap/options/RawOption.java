package org.jetlinks.coap.options;

import org.jetlinks.coap.utils.DataConvertingUtility;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author guyi
 */
final class RawOption implements Comparable<RawOption>, Serializable {

    final int optNumber;
    final byte[][] optValues;

    static RawOption fromString(int num, String[] stringVal) {
        return new RawOption(num, DataConvertingUtility.stringArrayToBytes(stringVal));
    }

    static RawOption fromUint(int num, long uintVal) {
        return new RawOption(num, new byte[][]{DataConvertingUtility.convertVariableUInt(uintVal)});
    }

    static RawOption fromString(int num, String stringVal) {
        return new RawOption(num, new byte[][]{DataConvertingUtility.encodeString(stringVal)});
    }

    static RawOption fromEmpty(int num) {
        return new RawOption(num, new byte[][]{{}});
    }

    RawOption(int optNumber, byte[][] optValues) {
        this.optNumber = optNumber;
        this.optValues = optValues;
    }

    RawOption(int optNumber, byte[] singleOptValue) {
        this.optNumber = optNumber;
        this.optValues = new byte[1][];
        this.optValues[0] = singleOptValue;
    }

    byte[] getFirstValue() {
        return (optValues.length > 0) ? optValues[0] : null;
    }

    @Override
    public int compareTo(RawOption o) {
        return (Integer.compare(optNumber, o.optNumber));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.optNumber;
        hash = 47 * hash + Arrays.deepHashCode(this.optValues);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RawOption other = (RawOption) obj;
        if (this.optNumber != other.optNumber) {
            return false;
        }
        if (!Arrays.deepEquals(this.optValues, other.optValues)) {
            return false;
        }
        return true;
    }
}

