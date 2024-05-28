package com.zbank.business.assembler.dto.impl;

import com.zbank.business.assembler.dto.AssemblerDTO;
import com.zbank.business.domain.DivisaDomain;
import com.zbank.business.domain.PerfilDomain;
import com.zbank.business.domain.TipoDocumentoDomain;
import static com.zbank.crosscutting.helpers.ObjectHelper.getObjectHelper;
import com.zbank.dto.DivisaDTO;
import com.zbank.dto.PerfilDTO;
import com.zbank.dto.TipoDocumentoDTO;
import java.util.ArrayList;
import java.util.List;

public final class PerfilAssemblerDTO implements AssemblerDTO<PerfilDomain, PerfilDTO> {

    private static final AssemblerDTO<TipoDocumentoDomain, TipoDocumentoDTO> tipoDocumentoAssembler= TipoDocumentoAssemblerDTO.getInstance();
    private static final AssemblerDTO<DivisaDomain, DivisaDTO> divisaAssembler = DivisaAssemblerDTO.getInstance();
    private static final AssemblerDTO<PerfilDomain, PerfilDTO> instance = new PerfilAssemblerDTO();

    public PerfilAssemblerDTO() {
        super();
    }

    public static final AssemblerDTO<PerfilDomain, PerfilDTO> getInstance() {
        return instance;
    }

    @Override
    public final PerfilDomain toDomain(final PerfilDTO data) {
        var perfilDtoTmp= getObjectHelper().getDefaultValue(data,PerfilDTO.build());
        var divisaDomain=divisaAssembler.toDomain(perfilDtoTmp.getDivisa());
        var tipoDocumentoDomain= tipoDocumentoAssembler.toDomain(perfilDtoTmp.getTipoDocumento());
        return PerfilDomain.build(perfilDtoTmp.getId(), perfilDtoTmp.getNombre(), perfilDtoTmp.getApellido(), tipoDocumentoDomain,
                perfilDtoTmp.getNumeroDocumento(), divisaDomain, perfilDtoTmp.getNombreUsuario(),
                perfilDtoTmp.getClave(), perfilDtoTmp.getCorreo());
    }

    @Override
    public final PerfilDTO toDTO(final PerfilDomain domain) {
        var perfilDomainTmp=getObjectHelper().getDefaultValue(domain,PerfilDomain.build());
        var divisaDTO= divisaAssembler.toDTO(perfilDomainTmp.getDivisa());
        var tipoDocumentoDTO=tipoDocumentoAssembler.toDTO(perfilDomainTmp.getTipoDocumento());
        return PerfilDTO.build().setId(perfilDomainTmp.getId()).setNombre(perfilDomainTmp.getNombre())
                .setApellido(perfilDomainTmp.getApellido()).setTipoDocumento(tipoDocumentoDTO).setNumeroDocumento(perfilDomainTmp
                        .getNumeroDocumento()).setDivisa(divisaDTO).setNombreUsuario(perfilDomainTmp.getNombreUsuario()).setCorreo(perfilDomainTmp
                        .getCorreo()).setClave(perfilDomainTmp.getClave()).setCorreo(perfilDomainTmp.getCorreo());
    }

    @Override
    public final List<PerfilDomain> toDomainCollection(final List<PerfilDTO> dtoCollection) {
        var dtoCollectionTmp=getObjectHelper().getDefaultValue(dtoCollection,new ArrayList<PerfilDTO>());
        var resultadosDomain=new ArrayList<PerfilDomain>();

        for (PerfilDTO perfilDTO:dtoCollectionTmp){
            var perfilDomainTmp= toDomain(perfilDTO);
            resultadosDomain.add(perfilDomainTmp);
        }
        return resultadosDomain;
    }

    @Override
    public final List<PerfilDTO> toDTOCollection(final List<PerfilDomain> domainCollection) {
        var domainCollectionTmp=getObjectHelper().getDefaultValue(domainCollection,new ArrayList<PerfilDomain>());
        return domainCollectionTmp.stream().map(this::toDTO).toList();
    }
}
