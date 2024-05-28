package com.zbank.business.domain;

import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class PerfilDomain {
    private UUID id;
    private String nombre;
    private String apellido;
    private TipoDocumentoDomain tipoDocumento;
    private long numeroDocumento;
    private DivisaDomain divisa;
    private String nombreUsuario;
    private String clave;
    private String correo;


    public PerfilDomain(final UUID id,final String nombre, String apellido,final TipoDocumentoDomain tipoDocumento,final long numeroDocumento,
                        final DivisaDomain divisa,final String nombreUsuario,final String clave, final String correo) {
        setNombre(nombre);
        setApellido(apellido);
        setTipoDocumento(tipoDocumento);
        setNumeroDocumento(numeroDocumento);
        setDivisa(divisa);
        setNombreUsuario(nombreUsuario);
        setClave(clave);
        setCorreo(correo);

    }

    public static final PerfilDomain build(final UUID id,final String nombre, String apellido,final TipoDocumentoDomain tipoDocumento,final long numeroDocumento,
                                           final DivisaDomain divisa,final String nombreUsuario,final String clave, final String correo) {
        return new PerfilDomain(id, nombre, apellido, tipoDocumento,numeroDocumento,divisa,nombreUsuario,clave,correo);
    }
    public static final PerfilDomain build(final UUID id) {
        return new PerfilDomain(id, TextHelper.EMPTY,TextHelper.EMPTY, TipoDocumentoDomain.build(),0, DivisaDomain.build(),
                TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY);
    }

    public static final PerfilDomain build() {
        return new PerfilDomain(UUIDHelper.getDefault(),TextHelper.EMPTY,TextHelper.EMPTY, TipoDocumentoDomain.build(),0, DivisaDomain.build(),
                TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(final String apellido) {
        this.apellido = TextHelper.applyTrim(apellido);
    }

    public TipoDocumentoDomain getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(final TipoDocumentoDomain tipoDocumento) {
        this.tipoDocumento =  ObjectHelper.getObjectHelper().getDefaultValue(tipoDocumento, TipoDocumentoDomain.build());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public DivisaDomain getDivisa() {
        return divisa;
    }

    public void setDivisa(DivisaDomain divisa) {
        this.divisa = ObjectHelper.getObjectHelper().getDefaultValue(divisa, DivisaDomain.build());
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = TextHelper.applyTrim(nombreUsuario);
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = TextHelper.applyTrim(clave);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = TextHelper.applyTrim(correo);
    }
}
