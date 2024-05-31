package com.zbank.business.assembler.entity.impl;

import com.zbank.business.assembler.entity.AssemblerEntity;
import com.zbank.business.domain.DivisaDomain;
import com.zbank.business.domain.PerfilDomain;
import com.zbank.business.domain.TipoDocumentoDomain;
import com.zbank.entity.DivisaEntity;
import com.zbank.entity.PerfilEntity;
import com.zbank.entity.TipoDocumentoEntity;

import java.util.ArrayList;
import java.util.List;

import static com.zbank.crosscutting.helpers.ObjectHelper.getObjectHelper;

public final class PerfilAssemblerEntity implements AssemblerEntity<PerfilDomain, PerfilEntity> {

    private static final AssemblerEntity<TipoDocumentoDomain, TipoDocumentoEntity> tipoDocumentoAssembler= TipoDocumentoAssemblerEntity.getInstance();
    private static final AssemblerEntity<DivisaDomain, DivisaEntity> divisaAssembler = DivisaAssemblerEntity.getInstance();
    private static final AssemblerEntity<PerfilDomain, PerfilEntity> instance = new PerfilAssemblerEntity();

    public PerfilAssemblerEntity() {
        super();
    }

    public static final AssemblerEntity<PerfilDomain, PerfilEntity> getInstance() {
        return instance;
    }

    @Override
    public final PerfilDomain toDomain(final PerfilEntity data) {
        var perfilEntityTmp= getObjectHelper().getDefaultValue(data,PerfilEntity.build());
        var divisaDomain=divisaAssembler.toDomain(perfilEntityTmp.getDivisa());
        var tipoDocumentoDomain= tipoDocumentoAssembler.toDomain(perfilEntityTmp.getTipoDocumento());
        return PerfilDomain.build(perfilEntityTmp.getId(), perfilEntityTmp.getNombre(), perfilEntityTmp.getApellido(), tipoDocumentoDomain,
                perfilEntityTmp.getNumeroDocumento(), divisaDomain, perfilEntityTmp.getNombreUsuario(),
                perfilEntityTmp.getClave(), perfilEntityTmp.getCorreo());
    }

    @Override
    public final PerfilEntity toEntity(final PerfilDomain domain) {
        var perfilDomainTmp=getObjectHelper().getDefaultValue(domain,PerfilDomain.build());
        var divisaEntity= divisaAssembler.toEntity(perfilDomainTmp.getDivisa());
        var tipoDocumentoEntity=tipoDocumentoAssembler.toEntity(perfilDomainTmp.getTipoDocumento());
        return PerfilEntity.build().setId(perfilDomainTmp.getId()).setNombre(perfilDomainTmp.getNombre())
                .setApellido(perfilDomainTmp.getApellido()).setTipoDocumento(tipoDocumentoEntity).setNumeroDocumento(perfilDomainTmp
                        .getNumeroDocumento()).setDivisa(divisaEntity).setNombreUsuario(perfilDomainTmp.getNombreUsuario()).setCorreo(perfilDomainTmp
                        .getCorreo()).setClave(perfilDomainTmp.getClave()).setCorreo(perfilDomainTmp.getCorreo());
    }

    @Override
    public final List<PerfilDomain> toDomainCollection(final List<PerfilEntity> entityCollection) {
        var dtoCollectionTmp=getObjectHelper().getDefaultValue(entityCollection,new ArrayList<PerfilEntity>());
        var resultadosDomain=new ArrayList<PerfilDomain>();

        for (PerfilEntity perfilEntity:dtoCollectionTmp){
            var perfilDomainTmp= toDomain(perfilEntity);
            resultadosDomain.add(perfilDomainTmp);
        }
        return resultadosDomain;
    }

    @Override
    public List<PerfilEntity> toEntityCollection(List<PerfilDomain> domainCollection) {
        var domainCollectionTmp=getObjectHelper().getDefaultValue(domainCollection,new ArrayList<PerfilDomain>());
        return domainCollectionTmp.stream().map(this::toEntity).toList();
    }
}
