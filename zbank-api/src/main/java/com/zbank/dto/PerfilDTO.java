package com.zbank.dto;

import static com.zbank.crosscutting.helpers.TextHelper.EMPTY;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;
import java.util.UUID;

public final class PerfilDTO {
    private UUID id;
    private String nombre;
    private String apellido;
    private TipoDocumentoDTO tipoDocumento;
    private int numeroDocumento;
    private DivisaDTO divisa;
    private String nombreUsuario;
    private String clave;
    private String correo;

    public PerfilDTO() {
        setId(UUIDHelper.generate());
        setNombre(EMPTY);
        setApellido(EMPTY);
        setTipoDocumento(TipoDocumentoDTO.build());
        setNumeroDocumento(numeroDocumento);
        setDivisa(DivisaDTO.build());
        setNombreUsuario(EMPTY);
        setClave(EMPTY);
        setCorreo(EMPTY);
    }

    public PerfilDTO(final UUID id, final String nombre, final String apellido,
                     final TipoDocumentoDTO tipoDocumento, final int numeroDocumento,
                     final DivisaDTO divisa, final String nombreUsuario,
                     final String clave, final String correo) {
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
        setTipoDocumento(tipoDocumento);
        setNumeroDocumento(numeroDocumento);
        setDivisa(divisa);
        setNombreUsuario(nombreUsuario);
        setClave(clave);
        setCorreo(correo);
    }

    public static final PerfilDTO build(){
        return new PerfilDTO();
    }

    public final UUID getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final String getApellido() {
        return apellido;
    }

    public final TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public final int getNumeroDocumento() {
        return numeroDocumento;
    }

    public final DivisaDTO getDivisa() {
        return divisa;
    }

    public final String getNombreUsuario() {
        return nombreUsuario;
    }

    public final String getClave() {
        return clave;
    }

    public final String getCorreo() {
        return correo;
    }

    public final PerfilDTO setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public final PerfilDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    public final PerfilDTO setApellido(final String apellido) {
        this.apellido =  TextHelper.applyTrim(apellido);
        return this;
    }

    public final PerfilDTO setTipoDocumento(final TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = ObjectHelper.getObjectHelper().
                getDefaultValue(tipoDocumento, new TipoDocumentoDTO());
        return this;
    }

    public final PerfilDTO setNumeroDocumento(final int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
        return this;
    }

    public final PerfilDTO setDivisa(final DivisaDTO divisa) {
        this.divisa = ObjectHelper.getObjectHelper().
                getDefaultValue(divisa, new DivisaDTO());
        return this;
    }

    public final PerfilDTO setNombreUsuario(final String nombreUsuario) {
        this.nombreUsuario =  TextHelper.applyTrim(nombreUsuario);
        return this;
    }

    public final PerfilDTO setClave(final String clave) {
        this.clave = TextHelper.applyTrim(clave);
        return this;
    }

    public final PerfilDTO setCorreo(final String correo) {
        this.correo = TextHelper.applyTrim(correo);
        return this;
    }
}
