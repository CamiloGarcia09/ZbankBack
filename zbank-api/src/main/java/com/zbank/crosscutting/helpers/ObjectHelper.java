package com.zbank.crosscutting.helpers;

public final class ObjectHelper {
//Esta clase se crea a si misma
    private static final ObjectHelper INSTANCE = new ObjectHelper();
//Estrategia de Singleton, con objetos instanciados.
    public ObjectHelper() {
        super();
    }
// Este es el metodo final que vamos a utilizar
    public static final ObjectHelper getObjectHelper(){
        return INSTANCE;
    }
// <> Esto significa generecidad, puede tomar el valor de lo que sea que le mandes en el parametro
    public <o> boolean isNull(o objeto){
        return objeto == null;
    }
// Retorna una "o" tipo Object
    public <o> o getDefaultValue(o objeto, o valorDefecto){
        return isNull(objeto) ? valorDefecto : objeto;
    }
}
