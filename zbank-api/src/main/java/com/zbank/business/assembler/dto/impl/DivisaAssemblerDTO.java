package com.zbank.business.assembler.dto.impl;


import com.zbank.business.assembler.dto.AssemblerDTO;
import com.zbank.business.domain.DivisaDomain;
import static com.zbank.crosscutting.helpers.ObjectHelper.getObjectHelper;
import com.zbank.dto.DivisaDTO;

import java.util.List;

public final class DivisaAssemblerDTO  implements AssemblerDTO<DivisaDomain, DivisaDTO> {

    private static final AssemblerDTO<DivisaDomain,DivisaDTO> instance= new DivisaAssemblerDTO();

    public DivisaAssemblerDTO() {
        super();
    }

    public static final AssemblerDTO<DivisaDomain, DivisaDTO> getInstance() {
        return instance;
    }

    @Override
    public final DivisaDomain toDomain(final DivisaDTO data) {
        var divisaDtoTmp= getObjectHelper().getDefaultValue(data, DivisaDTO.build());
        return DivisaDomain.build(divisaDtoTmp.getId(), divisaDtoTmp.getCodigoISO(),divisaDtoTmp.getNombre());
    }

    @Override
    public final DivisaDTO toDTO(final DivisaDomain domain) {
         var divisaDomainTmp=getObjectHelper().getDefaultValue(domain,DivisaDomain.build());
         return DivisaDTO.build().setId(divisaDomainTmp.getId()).setCodigoISO(divisaDomainTmp.getCodigoISO())
                 .setNombre(divisaDomainTmp.getNombre());
    }

    @Override
    public final List<DivisaDTO> toDTOCollection(final List<DivisaDomain> domainCollection) {
        return List.of();
    }

    @Override
    public final List<DivisaDomain> toDomainCollection(final List<DivisaDTO> entityCollection) {
        return List.of();
    }
}
