package com.noob.docker_boot.other.exam;

import java.util.List;

public class MemPool {

    private List<Byte> memory;

    // 5 个 40k 的内存，后续每次分配 5k/80k 的内存
    private int init(int poolNum, int poolSize, int blockSize) {
        return 0;
    }

    // 释放资源
    private void cleanup() {

    }

    // 从内存池中申请一个大小为 block_size 大小的内存块
    private List<Byte> alloc(int tag) {
        return null;
    }

    // 释放 pointer 所指的内存块
    private void free() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
