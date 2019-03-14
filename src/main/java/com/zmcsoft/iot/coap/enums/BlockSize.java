package com.zmcsoft.iot.coap.enums;

import lombok.Getter;

/**
 * @author guyi
 */
@Getter
public enum BlockSize {

    S_16(4, false), S_32(5, false), S_64(6, false), S_128(7, false), S_256(8, false), S_512(9, false), S_1024(10, false), S_1024_BERT(10, true);
    private byte szx;
    private boolean bert;

    BlockSize(int szx, boolean bert) {
        this.szx = (byte) (szx - 4);
        this.bert = bert;
    }

    public int getSize() {
        return 1 << (szx + 4);
    }

    public int numberOfBlocksPerMessage(int totalSize) {
        return bert ? totalSize / getSize() : 1;
    }


    public static BlockSize fromRawSzx(byte rawSzx) {
        return values()[rawSzx];
    }

    public byte toRawSzx() {
        if (bert) {
            return 7;
        } else {
            return szx;
        }
    }

    public boolean isBert() {
        return bert;
    }

}
