package com.zbank.business.usecase;

public interface UseCaseWithOutReturn<T>{
    void execute(T data);
}
