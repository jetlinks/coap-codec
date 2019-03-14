package com.zmcsoft.iot.coap.options;

import com.zmcsoft.iot.coap.enums.BlockSize;
import com.zmcsoft.iot.coap.utils.DataConvertingUtility;

import java.io.Serializable;

/**
 * @author guyi
 */
public final class BlockOption implements Serializable {

    private final int blockNr;
    private final boolean more;
    private final BlockSize blockSize;

    public BlockOption(int blockNr, BlockSize blockSize, boolean more) {
        this.blockNr = blockNr;
        this.blockSize = blockSize;
        this.more = more;
    }

    public BlockOption(byte[] raw) {
        int bl = DataConvertingUtility.readVariableULong(raw).intValue();
        blockNr = bl >> 4;
        more = (bl & 0x8) != 0;
        byte szx = (byte) (bl & 0x07);
        blockSize = BlockSize.fromRawSzx(szx);
    }

    public byte[] toBytes() {
        int block = blockNr << 4;
        if (more) {
            block |= 1 << 3;
        }
        block |= blockSize.toRawSzx();
        return DataConvertingUtility.convertVariableUInt(block);
    }

    /**
     * @return the blockNr
     */
    public int getNr() {
        return blockNr;
    }

    public BlockSize getBlockSize() {
        return blockSize;
    }

    public boolean isBert() {
        return blockSize.isBert();
    }

    /**
     * @return the size
     */
    public int getSize() {
        return blockSize.getSize();
    }

    public boolean hasMore() {
        return more;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BlockOption)) {
            return false;
        }
        if (obj.hashCode() != this.hashCode()) {
            return false;
        }

        return ((BlockOption) obj).blockSize == this.blockSize // enum value comparison
                && ((BlockOption) obj).blockNr == this.blockNr
                && ((BlockOption) obj).more == this.more;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.blockNr;
        hash = 67 * hash + this.blockSize.getSzx();
        hash = 67 * hash + (this.blockSize.isBert() ? 1 : 0);
        hash = 67 * hash + (this.more ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.blockNr);
        sb.append('|').append(more ? "more" : "last");
        if (isBert()) {
            sb.append("|BERT");
        } else {
            sb.append('|').append(getSize());
        }
        return sb.toString();
    }
}
