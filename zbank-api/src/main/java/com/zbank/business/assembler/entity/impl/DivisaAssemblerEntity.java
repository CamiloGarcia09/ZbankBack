package com.zbank.business.assembler.entity.impl;

import com.zbank.business.assembler.entity.AssemblerEntity;
import com.zbank.business.domain.DivisaDomain;
import com.zbank.entity.DivisaEntity;

import java.util.ArrayList;
import java.util.List;

import static com.zbank.crosscutting.helpers.ObjectHelper.getObjectHelper;

public final class DivisaAssemblerEntity implements AssemblerEntity<DivisaDomain, DivisaEntity> {

    private static final AssemblerEntity<DivisaDomain, DivisaEntity> instance= new DivisaAssemblerEntity();

    public DivisaAssemblerEntity() {
        super();
    }

    public static final AssemblerEntity<DivisaDomain, DivisaEntity> getInstance() {
        return instance;
    }

    @Override
    public final DivisaDomain toDomain(final DivisaEntity data) {
        var divisaEntityTmp= getObjectHelper().getDefaultValue(data, DivisaEntity.build());
        return DivisaDomain.build(divisaEntityTmp.getId(), divisaEntityTmp.getCodigoISO(),divisaEntityTmp.getNombre());
    }

    @Override
    public final DivisaEntity toEntity(final DivisaDomain domain) {
        var divisaDomainTmp=getObjectHelper().getDefaultValue(domain,DivisaDomain.build());
        return DivisaEntity.build().setId(divisaDomainTmp.getId()).setCodigoISO(divisaDomainTmp.getCodigoISO())
                .setNombre(divisaDomainTmp.getNombre());
    }

    @Override
    public List<DivisaDomain> toDomainCollection(List<DivisaEntity> entityCollection) {
        var entityCollectionTmp=getObjectHelper().getDefaultValue(entityCollection,new ArrayList<DivisaEntity>());
        var resultadosDomain=new ArrayList<DivisaDomain>();

        for (DivisaEntity divisaEntity:entityCollectionTmp){
            var DivisaDomainTmp= toDomain(divisaEntity);
            resultadosDomain.add(DivisaDomainTmp);
        }
        return resultadosDomain;
    }

    @Override
    public List<DivisaEntity> toEntityCollection(List<DivisaDomain> domainCollection) {
        var domainCollectionTmp=getObjectHelper().getDefaultValue(domainCollection,new ArrayList<DivisaDomain>());
        return domainCollectionTmp.stream().map(this::toEntity).toList();
    }

}
