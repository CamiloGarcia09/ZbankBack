package com.zbank.business.assembler.dto.impl;

import com.zbank.business.assembler.dto.AssemblerDTO;
import com.zbank.business.domain.TipoDocumentoDomain;
import static com.zbank.crosscutting.helpers.ObjectHelper.getObjectHelper;
import com.zbank.dto.TipoDocumentoDTO;

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
    public final List<TipoDocumentoDTO> toDTOCollection(final List<TipoDocumentoDomain> domainCollection) {
        return List.of();
    }

    @Override
    public final List<TipoDocumentoDomain> toDomainCollection(final List<TipoDocumentoDTO> entityCollection) {
        return List.of();
    }
}
