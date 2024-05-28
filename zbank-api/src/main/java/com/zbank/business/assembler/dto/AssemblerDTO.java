package com.zbank.business.assembler.dto;

import com.zbank.business.assembler.Assembler;

import java.util.List;

public interface AssemblerDTO<D, K> extends Assembler<D, K> {

    K toDTO(D domain);

    List<K> toDTOCollection(List<D> domainCollection);
}
