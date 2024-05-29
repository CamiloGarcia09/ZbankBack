package com.zbank.business.usecase;

public interface UseCaseWithReturn<T,R> {
    R execute(T data);
}
