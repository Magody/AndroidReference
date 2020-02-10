package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos;


import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {

    public static boolean camposLlenos(String[] campos){

        boolean llenos = true;

        for (String campo:
             campos) {
            if(campo.equals("")){
                llenos = false;
                break;
            }
        }


        return llenos;
    }


    public static boolean puntoDentroDeQuito(double latitud, double longitud) {
        /*
        Nono						Tababela
        -0.089615, -78.569322		-0.089615, -78.365817

        Cutuglahua						Pintag
        -0.364914, -78.569322			-0.364914, -78.365817
        * */
        double[] puntoSuperiorIzquierda = new double[]{-0.089615, -78.569322};
        double[] puntoInferiorDerecha = new double[]{-0.364914, -78.365817};

        //comprueba si la latitud y longitud está dentro de esos puntos
        return (latitud <= puntoSuperiorIzquierda[0] && longitud >= puntoSuperiorIzquierda[1] &&
                (latitud >= puntoInferiorDerecha[0] && longitud <= puntoInferiorDerecha[1]));

    }

    public static boolean esCorreoValido(String correo){
        final String EMAIL_REGEX = "^[\\w-+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);;
        Matcher matcher = pattern.matcher(correo);;
        return matcher.matches();
    }

    public static boolean estaLongitudStringEnRango(String cadena, int minimo, int maximo){

        int longitud = cadena.length();

        return (longitud >= minimo && longitud <= maximo);

    }

    /*
     * El usuario contiene solo letras, numeros y/o underscore, con longitud entre 3 a 12. Debe iniciar con letra
     * */
    public static boolean esNombreUsuarioValido(String usuario){
        final String USUARIO_REGEX = "^[A-z][\\d\\w]{2,11}$";
        Pattern pattern = Pattern.compile(USUARIO_REGEX, Pattern.CASE_INSENSITIVE);;
        Matcher matcher = pattern.matcher(usuario);;
        return matcher.matches();
    }

    /*
     * La contraseña debe tener entre 6 a 16 caracteres (letras y/o números)
     * */
    public static boolean esContraseniaValida(String contrasenia){
        final String CONTRASENIA_REGEX = "^[A-z\\d]{6,16}$";
        Pattern pattern = Pattern.compile(CONTRASENIA_REGEX, Pattern.CASE_INSENSITIVE);;
        Matcher matcher = pattern.matcher(contrasenia);;
        return matcher.matches();
    }


    public static boolean esRUCValido(String cedula){
        return esCedulaValida(cedula.substring(0, 10)) && cedula.length() == 13;
    }

    public static boolean esCedulaValida(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                    int verificador = Integer.parseInt(cedula.substring(9,10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    }
                    else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta " + cedula);
        }
        return cedulaCorrecta;
    }


    public static boolean esTelefonoConvencionalValido(String telefono_convencional) {


        final String TELEFONO_CONVENCIONAL_REGEX = "^[0-9]{7,9}$";
        Pattern pattern = Pattern.compile(TELEFONO_CONVENCIONAL_REGEX, Pattern.CASE_INSENSITIVE);;
        Matcher matcher = pattern.matcher(telefono_convencional);;
        return matcher.matches();
    }

    public static boolean esTelefonoValido(String telefono_movil) {
        final String TELEFONO_MOVIL_REGEX = "^[0-9]{8,10}$";
        Pattern pattern = Pattern.compile(TELEFONO_MOVIL_REGEX, Pattern.CASE_INSENSITIVE);;
        Matcher matcher = pattern.matcher(telefono_movil);;
        return matcher.matches();
    }

    public static boolean esNombreApellidoValido(String palabra) {


        final String NOMBRE_REGEX = "^[A-záéíóúÁÉÍÓÚñü\\s]{3,50}$";
        Pattern pattern = Pattern.compile(NOMBRE_REGEX, Pattern.CASE_INSENSITIVE);;
        Matcher matcher = pattern.matcher(palabra);;
        return matcher.matches();
    }




    public static boolean esFechaDeNacimientoValida(String fecha){
        try{
            String[] datos = fecha.split("/");




            if(datos.length == 3){
                SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
                Date date1=formatter1.parse(fecha);

                System.out.println(fecha);
                System.out.println(date1);
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
                cal.setTime(date1);

                if(Integer.parseInt(datos[0]) >= 1 && Integer.parseInt(datos[0]) <= 31){
                    if(Integer.parseInt(datos[1]) >= 1 && Integer.parseInt(datos[1]) <= 12){
                        if(Integer.parseInt(datos[2]) >= 1900 && Integer.parseInt(datos[2]) <= 2019){
                            return true;
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }






            }else{
                return false;
            }


        }catch(Exception error){
            return false;
        }


    }


    public static boolean esTarjetaValida(String tarjeta){
        final String NOMBRE_REGEX = "^[0-9]{16}$";
        Pattern pattern = Pattern.compile(NOMBRE_REGEX, Pattern.CASE_INSENSITIVE);;
        Matcher matcher = pattern.matcher(tarjeta);;
        return matcher.matches();
    }


}
