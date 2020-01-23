package com.software2_grupo3.ingenieriasoftware2proyecto.Modelos;

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
}
