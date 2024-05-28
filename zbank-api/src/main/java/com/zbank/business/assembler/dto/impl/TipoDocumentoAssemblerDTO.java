package com.zbank.business.assembler.dto.impl;

import com.zbank.business.assembler.dto.AssemblerDTO;
import com.zbank.business.domain.TipoDocumentoDomain;
import static com.zbank.crosscutting.helpers.ObjectHelper.getObjectHelper;
import com.zbank.dto.TipoDocumentoDTO;

import java.util.ArrayList;
import java.util.List;

public final class TipoDocumentoAssemblerDTO implements AssemblerDTO<TipoDocumentoDomain, TipoDocumentoDTO> {

    private static final AssemblerDTO<TipoDocumentoDomain, TipoDocumentoDTO> instance = new TipoDocumentoAssemblerDTO();

    public TipoDocumentoAssemblerDTO() {
        super();
    }

    public static final AssemblerDTO<TipoDocumentoDomain, TipoDocumentoDTO> getInstance() {
        return instance;
    }
    @Override
    public final TipoDocumentoDomain toDomain(final TipoDocumentoDTO data) {
        var tipoDocumentoDtoTmp= getObjectHelper().getDefaultValue(data,TipoDocumentoDTO.build());
        return TipoDocumentoDomain.build(tipoDocumentoDtoTmp.getId(),tipoDocumentoDtoTmp.getNombre(),tipoDocumentoDtoTmp.getAbreviacion());

    }

    @Override
    public final TipoDocumentoDTO toDTO(final TipoDocumentoDomain domain) {
        var tipoDocumentoDomainTmp= getObjectHelper().getDefaultValue(domain,TipoDocumentoDomain.build());
        return TipoDocumentoDTO.build().setId(tipoDocumentoDomainTmp.getId()).setNombre(tipoDocumentoDomainTmp.getNombre())
                .setAbreviacion(tipoDocumentoDomainTmp.getAbreviacion());
    }

    @Override
    public final List<TipoDocumentoDomain> toDomainCollection(final List<TipoDocumentoDTO> dtoCollection) {
        var dtoCollectionTmp=getObjectHelper().getDefaultValue(dtoCollection,new ArrayList<TipoDocumentoDTO>());
        var resultadosDomain=new ArrayList<TipoDocumentoDomain>();

        for (TipoDocumentoDTO tipoDocumentoDTO:dtoCollectionTmp){
            var tipoDocumentoDomainTmp= toDomain(tipoDocumentoDTO);
            resultadosDomain.add(tipoDocumentoDomainTmp);
        }
        return resultadosDomain;
    }

    @Override
    public final List<TipoDocumentoDTO> toDTOCollection(final List<TipoDocumentoDomain> domainCollection) {
        var domainCollectionTmp=getObjectHelper().getDefaultValue(domainCollection,new ArrayList<TipoDocumentoDomain>());
        return domainCollectionTmp.stream().map(this::toDTO).toList();
    }
}
