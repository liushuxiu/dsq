package com.wangwenjun.java8;


import java.util.Objects;


@FunctionalInterface
public interface MyFunction<T, R> {

    R apply(T t);
    default <V> MyFunction<V, R> compose(MyFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }


}
