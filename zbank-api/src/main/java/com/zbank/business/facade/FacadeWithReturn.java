package com.zbank.business.facade;

public interface FacadeWithReturn <T, K>{

    K execute(T dto);
}
