package com.zbank.crosscutting.exceptions.messageCatalog.data;

import static com.zbank.crosscutting.helpers.TextHelper.UNDERLINE;
import static com.zbank.crosscutting.helpers.TextHelper.concatenate;

public enum CodigoMensaje {
    M00001(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00001", true),
    M00002(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00002", true),
    M00003(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00003", true),
    M00004(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00004", true),
    M00005(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00005", true),
    M00006(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00006", true),
    M00007(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00007", true),
    M00008(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00008", true),
    M00009(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00009", true),
    M00010(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00010", true),
    M00011(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00011", true),
    M00012(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00012", true),
    M00013(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00013", true),
    M00014(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00014", true),
    M00015(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00015", true),
    M00016(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00016", true),
    M00017(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00017", true),
    M00018(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00018", true),
    M00019(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00019", true),
    M00020(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00020", true),
    M00021(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00021", true),
    M00022(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00022", true),
    M00023(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00023", true),

    M00024(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00024", false),
    M00025(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00025", false);


    private TipoMensaje tipo;
    private CategoriaMensaje categoria;
    private String codigo;
    private boolean base;

    private CodigoMensaje(final TipoMensaje tipo,
                          final CategoriaMensaje categoria, final String codigo,
                          final boolean base) {
        setTipo(tipo);
        setCategoria(categoria);
        setCodigo(codigo);
        setBase(base);
    }

    public final TipoMensaje getTipo() {
        return tipo;
    }

    public final CategoriaMensaje getCategoria() {
        return categoria;
    }

    public final String getCodigo() {
        return codigo;
    }

    private final void setTipo(final TipoMensaje tipo) {
        this.tipo = tipo;
    }

    private final void setCategoria(final CategoriaMensaje categoria) {
        this.categoria = categoria;
    }

    private final void setCodigo(final String codigo) {
        this.codigo = codigo;
    }

    private final void setBase(final boolean base) {
        this.base = base;
    }

    public final boolean isBase() {
        return base;
    }

    public String getIdentificador() {
        return concatenate(getTipo().name(), UNDERLINE,
                getCategoria().name(), UNDERLINE,
                getCodigo());
    }
}
