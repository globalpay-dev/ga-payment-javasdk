package com.lianpay.globalpay.domain;

public class ImmutableTriple<L, M, R> {
    public final L left;
    public final M middle;
    public final R right;

    public static <L, M, R> ImmutableTriple<L, M, R> of(L left, M middle, R right) {
        return new ImmutableTriple(left, middle, right);
    }

    public ImmutableTriple(L left, M middle, R right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    public L getLeft() {
        return this.left;
    }

    public M getMiddle() {
        return this.middle;
    }

    public R getRight() {
        return this.right;
    }
}
