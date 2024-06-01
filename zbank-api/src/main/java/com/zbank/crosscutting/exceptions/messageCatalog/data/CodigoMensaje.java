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

    //Mensajes propios zbank
    M00024(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00024", false),
    M00025(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00025", false),
    M00026(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00026", false),
    M00027(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00027",false),
    M00028(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00028", false),
    M00029(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00029",false),
    M00030(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00030", false),
    M00031(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00031",false),
    M00032(TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"00032",false),
    M00033(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00033", false),
    M00034(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00034", false),
    M00035(TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"00035",false),
    M00036(TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"00036",false),
    M00037(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00037", false),
    M00038(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00038", false),
    M00039(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00039", false),
    M00040(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00040", false),
    M00041(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00041", false),
    M00042(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00042", false),
    M00043(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00043", false),
    M00044(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00044", false),
    M00045(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00045", false),
    M00046(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00046", false),
    M00047(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00047", false),
    M00048(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00048", false),
    M00049(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00049", false),
    M00050(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00050", false),
    M00051(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00051", false),
    M00052(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00052", false),
    M00053(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00053", false),
    M00054(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00054", false),
    M00055(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00055", false),
    M00056(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00056", false),
    M00057(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00057", false),
    M00058(TipoMensaje.USUARIO, CategoriaMensaje.EXITO, "00058", false),
    M00059(TipoMensaje.USUARIO, CategoriaMensaje.EXITO, "00059", false),
    M00060(TipoMensaje.USUARIO, CategoriaMensaje.EXITO, "00060", false),
    M00061(TipoMensaje.USUARIO, CategoriaMensaje.EXITO, "00061", false),
    M00062(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00062", false),
    M00063(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00063", false),
    M00064(TipoMensaje.TECNICO, CategoriaMensaje.ADVERTENCIA, "00064", false),
    M00065(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00065", false),
    M00066(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00066", false),
    M00067(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00067", false),
    M00068(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00068", false),
    M00069(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00069", false),
    M00070(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00070", false),
    M00071(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00071", false),
    M00072(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00072", false),
    M00073(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00073", false),
    M00074(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00074", false),
    M00075(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00075", false),

    M00076(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00076", false),
    M00077(TipoMensaje.USUARIO, CategoriaMensaje.INFORMACION, "00077", false),
    M00078(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00078", false),
    M00079(TipoMensaje.USUARIO, CategoriaMensaje.INFORMACION, "00079", false),
    M00080(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00080", false);

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

    public final boolean isBase() {
        return base;
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

    public String getIdentificador() {
        return concatenate(getTipo().name(), UNDERLINE,
                getCategoria().name(), UNDERLINE,
                getCodigo());
    }
}
