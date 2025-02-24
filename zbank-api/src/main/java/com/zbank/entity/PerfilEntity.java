package com.zbank.entity;

import static com.zbank.crosscutting.helpers.TextHelper.EMPTY;

import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class PerfilEntity {
    private UUID id;
    private String nombre;
    private String apellido;
    private TipoDocumentoEntity tipoDocumento;
    private long numeroDocumento;
    private DivisaEntity divisa;
    private String nombreUsuario;
    private String clave;
    private String correo;

    public PerfilEntity() {
        setId(UUIDHelper.getDefault());
        setNombre(EMPTY);
        setApellido(EMPTY);
        setTipoDocumento(TipoDocumentoEntity.build());
        setNumeroDocumento(numeroDocumento);
        setDivisa(DivisaEntity.build());
        setNombreUsuario(EMPTY);
        setClave(EMPTY);
        setCorreo(EMPTY);
    }

    public PerfilEntity(final UUID id, final String nombre, final String apellido,
                        final TipoDocumentoEntity tipoDocumento, final long numeroDocumento,
                        final DivisaEntity divisa, final String nombreUsuario,
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

    public static final PerfilEntity build(){
        return new PerfilEntity();
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

    public final TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }

    public final long getNumeroDocumento() {
        return numeroDocumento;
    }

    public final DivisaEntity getDivisa() {
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

    public final PerfilEntity setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public final PerfilEntity setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    public final PerfilEntity setApellido(final String apellido) {
        this.apellido =  TextHelper.applyTrim(apellido);
        return this;
    }

    public final PerfilEntity setTipoDocumento(final TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = ObjectHelper.getObjectHelper().
                getDefaultValue(tipoDocumento, new TipoDocumentoEntity());
        return this;
    }

    public final PerfilEntity setNumeroDocumento(final long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
        return this;
    }

    public final PerfilEntity setDivisa(final DivisaEntity divisa) {
        this.divisa = ObjectHelper.getObjectHelper().
                getDefaultValue(divisa, new DivisaEntity());
        return this;
    }

    public final PerfilEntity setNombreUsuario(final String nombreUsuario) {
        this.nombreUsuario =  TextHelper.applyTrim(nombreUsuario);
        return this;
    }

    public final PerfilEntity setClave(final String clave) {
        this.clave = TextHelper.applyTrim(clave);
        return this;
    }

    public final PerfilEntity setCorreo(final String correo) {
        this.correo = TextHelper.applyTrim(correo);
        return this;
    }
}
