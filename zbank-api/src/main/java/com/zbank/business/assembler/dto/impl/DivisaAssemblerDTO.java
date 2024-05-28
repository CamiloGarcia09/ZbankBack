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
    public DivisaDomain toDomain(final DivisaDTO data) {
        var divisaDtoToTmp= getObjectHelper().getDefaultValue(data, DivisaDTO.build());
        return DivisaDomain.build(divisaDtoToTmp.getId(), divisaDtoToTmp.getCodigoISO(),divisaDtoToTmp.getNombre());
    }

    @Override
    public DivisaDTO toDTO(final DivisaDomain domain) {
         var divisaDomainTmp=getObjectHelper().getDefaultValue(domain,DivisaDomain.build());
         return DivisaDTO.build().setId(divisaDomainTmp.getId()).setCodigoISO(divisaDomainTmp.getCodigoISO())
                 .setNombre(divisaDomainTmp.getNombre());
    }

    @Override
    public List<DivisaDTO> toDTOCollection(List<DivisaDomain> domainCollection) {
        return List.of();
    }
    @Override
    public List<DivisaDomain> toDomainCollection(List<DivisaDTO> entityCollection) {
        return List.of();
    }
}
