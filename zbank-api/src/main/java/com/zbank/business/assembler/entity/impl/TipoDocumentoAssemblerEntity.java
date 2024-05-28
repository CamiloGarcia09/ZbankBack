package com.zbank.business.assembler.entity.impl;

import com.zbank.business.assembler.entity.AssemblerEntity;
import com.zbank.business.domain.TipoDocumentoDomain;
import static com.zbank.crosscutting.helpers.ObjectHelper.getObjectHelper;

import com.zbank.dto.TipoDocumentoDTO;
import com.zbank.entity.TipoDocumentoEntity;

import java.util.ArrayList;
import java.util.List;

public final class TipoDocumentoAssemblerEntity implements AssemblerEntity <TipoDocumentoDomain, TipoDocumentoEntity> {

    private static final AssemblerEntity<TipoDocumentoDomain, TipoDocumentoEntity> instance = new TipoDocumentoAssemblerEntity();

    public TipoDocumentoAssemblerEntity() {
        super();
    }

    public static final AssemblerEntity<TipoDocumentoDomain, TipoDocumentoEntity> getInstance() {
        return instance;
    }

    @Override
    public final TipoDocumentoDomain toDomain(final TipoDocumentoEntity data) {
        var tipoDocumentoEntityTmp= getObjectHelper().getDefaultValue(data,TipoDocumentoEntity.build());
        return TipoDocumentoDomain.build(tipoDocumentoEntityTmp.getId(),tipoDocumentoEntityTmp.getNombre(),tipoDocumentoEntityTmp.getAbreviacion());

    }

    @Override
    public final TipoDocumentoEntity toEntity(final TipoDocumentoDomain domain) {
        var tipoDocumentoDomainTmp= getObjectHelper().getDefaultValue(domain,TipoDocumentoDomain.build());
        return TipoDocumentoEntity.build().setId(tipoDocumentoDomainTmp.getId()).setNombre(tipoDocumentoDomainTmp.getNombre())
                .setAbreviacion(tipoDocumentoDomainTmp.getAbreviacion());
    }

    @Override
    public List<TipoDocumentoDomain> toDomainCollection(List<TipoDocumentoEntity> entityCollection) {
        var entityCollectionTmp=getObjectHelper().getDefaultValue(entityCollection,new ArrayList<TipoDocumentoEntity>());
        var resultadosDomain=new ArrayList<TipoDocumentoDomain>();

        for (TipoDocumentoEntity tipoDocumentoEntity:entityCollectionTmp){
            var tipoDocumentoDomainTmp= toDomain(tipoDocumentoEntity);
            resultadosDomain.add(tipoDocumentoDomainTmp);
        }
        return resultadosDomain;
    }

    @Override
    public List<TipoDocumentoEntity> toEntityCollection(List<TipoDocumentoDomain> domainCollection) {
        var domainCollectionTmp=getObjectHelper().getDefaultValue(domainCollection,new ArrayList<TipoDocumentoDomain>());
        return domainCollectionTmp.stream().map(this::toEntity).toList();
    }
}
