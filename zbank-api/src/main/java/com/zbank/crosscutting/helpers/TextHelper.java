package com.zbank.crosscutting.helpers;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

//Los helpers son ayudantes, hacen su funcion y desaparecen
public final class TextHelper {
//Estrategia de Singleton (Todos los metodos son esticos)
    public static final String EMPTY = "";
    public static final String UNDERLINE = "_";
    private static final String LISTA_SOLO_LETRAS="^[A-Za-záéíóúÁÉÍÓÚ]+$";
    private static final String LISTA_SOLO_LETRAS_DIGITOS_ESPACIOS="^[0-9A-Za-záéíóúÁÉÍÓÚ]+$";
    private static final String PATTERN_CORREO_ELECTRONICO = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String PATTERN_NUMERO_TELEFONO = "^[0-9]+$";
    private static final List<Character> caracteresEspeciales = Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '[', ']', '{', '}', ';', ':', ',', '.', '<', '>', '?');

    //Constructor privado, nadie va a poder instanciar la clase, Patron SINGLETON
    private TextHelper() {
        super();
    }
    //Es nulo?
    public static final boolean isNull(final String palabra) {
        return ObjectHelper.getObjectHelper().isNull(palabra);  //Utilizamos el metodo generalizado que creamos
    }
    //Es nulo o vacio?
    public static final boolean isNullOrEmpty(final String palabra) {
        return isNull(palabra) || EMPTY.equals(applyTrim(palabra)); //Trim le quita los espacios en blanco
    }
    //Palabra por defecto
    public static final String getDefaultValue(final String palabra, final String palabraDefault) {
        return ObjectHelper.getObjectHelper().getDefaultValue(palabra, palabraDefault); //? y : Son operadores ternarios, reemplazan el if
        //Es nulo o vacio (?) SI SI devuelve palabraPorDefecto (:) SI NO devuelve la palabra ingresada
        //Utilizamos el metodo generalizado que creamos
    }
    //Si tiene un valor devuelve el valor sino devuelve un ""
    public static final String getDefaultValue(final String palabra) {
        return getDefaultValue(palabra, EMPTY);

    }
    //Le quita los vacios a una cadena
    public static final String applyTrim(final String palabra){
        return getDefaultValue(palabra).trim();
    }
    //Los tres puntos significa argumentos variables
    //Siempre se manda como ultimo parametro del metodo

    public static final String concatenate(final String ... strigns){
        final var sb = new StringBuilder(EMPTY);
        // var significa inferencia de tipos, apunta a la programacion funcional
        if (!ObjectHelper.getObjectHelper().isNull(strigns)){
            for (final var string: strigns){
                sb.append(applyTrim(string));
            }
        }
        return sb.toString();
    }

    public static String reemplazarParametro(String mensaje, String... parametros) {
        String mensajeReemplazado = mensaje;
        for(int i = 0; i< parametros.length; i++) {
            String marcador = "$[" + (i+1) + "}";
            mensajeReemplazado = mensajeReemplazado.replace(marcador, parametros[i]);
        }
        return mensajeReemplazado;
    }

    public static boolean longitudMinimaPermitida (final String valor, final int longitud) {
        return applyTrim(valor).length()>= longitud;
    }
    public static boolean longitudMaximaPermitida (final String valor, final int longitud) {
        return applyTrim(valor).length()<= longitud;
    }
    public static final boolean SoloLetras(final String valor) {
        return getDefaultValue(valor).matches(LISTA_SOLO_LETRAS);
    }
    public static final boolean SoloLetrasDigitosEspacios(final String valor) {
        return getDefaultValue(valor).matches(LISTA_SOLO_LETRAS_DIGITOS_ESPACIOS);
    }
    public static final boolean contieneFormatoCorreo(final String valor) {
        return getDefaultValue(valor).matches(PATTERN_CORREO_ELECTRONICO);
    }
    public static final boolean contieneSoloDigitos(final String valor) {
        return getDefaultValue(valor).matches(PATTERN_NUMERO_TELEFONO);
    }
    public static boolean validarClave(String contraseña) {
        boolean contieneMayuscula = !contraseña.equals(contraseña.toLowerCase());
        boolean contieneMinuscula = !contraseña.equals(contraseña.toUpperCase());
        boolean contieneNumero = contraseña.matches(".*\\d.*");
        Pattern patronCaracterEspecial = Pattern.compile("[!@#$%^&*()\\[\\]{};:,.<>?]");
        boolean contieneCaracterEspecial = patronCaracterEspecial.matcher(contraseña).find();
        return contieneMayuscula && contieneMinuscula && contieneNumero && contieneCaracterEspecial;
    }
}
