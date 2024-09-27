package com.lianpay.globalpay.domain;

public class ImmutablePair<L, R> {
    public final L left;
    public final R right;

    public static <L, R> ImmutablePair of(L left, R right) {
        return new ImmutablePair(left, right);
    }

    public ImmutablePair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }
}
