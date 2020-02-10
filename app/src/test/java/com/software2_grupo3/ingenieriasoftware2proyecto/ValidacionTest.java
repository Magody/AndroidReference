package com.software2_grupo3.ingenieriasoftware2proyecto;

import com.software2_grupo3.ingenieriasoftware2proyecto.Modelos.Validacion;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ValidacionTest {

    @Test
    public void puntoDentroDeQuito() {

        double[][] puntosCorrectos = new double[][]{
                {-0.09, -78.40},
                {-0.15, -78.40},
                {-0.10687423260311008, -78.44764128327371}
        };
        double[][] puntosIncorrectos = new double[][]{
                {0, 0},
                {-1, 15}
        };

        for (double[] punto : puntosCorrectos) {
            assertTrue(Validacion.puntoDentroDeQuito(punto[0], punto[1]));
        }

        for (double[] punto : puntosIncorrectos) {
            assertFalse(Validacion.puntoDentroDeQuito(punto[0], punto[1]));
        }
    }

    @Test
    public void camposLlenos() {
        String[] camposCorrectos = new String[]{"Hey Santa!", "1748754781"};
        String[] camposIncorrectos = new String[]{"Hey Santa!", ""};
        assertTrue(Validacion.camposLlenos(camposCorrectos));
        assertFalse(Validacion.camposLlenos(camposIncorrectos));
    }

    @Test
    public void esCorreoValido(){
        String[] camposCorrectos = new String[]{"meliodasfistery@gmail.com", "danny.diaz@epn.edu.ec", "dennis_deny@hotmail.com"};
        String[] camposIncorrectos = new String[]{"Hey Santa!", "correo@mail", "--343@.dr"};

        for (String correo : camposCorrectos) {
            assertTrue(Validacion.esCorreoValido(correo));
        }

        for (String correo : camposIncorrectos) {
            assertFalse(Validacion.esCorreoValido(correo));
        }

    }

    @Test
    public void esFechaValida(){
        String[] camposCorrectos = new String[]{"05/12/1997", "05/1/1992", "05/12/2018"};
        String[] camposIncorrectos = new String[]{"Hey Santa!", "50/12/1997", "10-12-1997", "0/12/1997"};

        for (String fecha : camposCorrectos) {
            assertTrue(Validacion.esFechaDeNacimientoValida(fecha));
        }

        for (String fecha : camposIncorrectos) {
            assertFalse(Validacion.esFechaDeNacimientoValida(fecha));
        }

    }

    @Test
    public void esTarjetaValida(){
        String[] camposCorrectos = new String[]{"1234598672345679", "1234598632345679", "1234593672345679"};
        String[] camposIncorrectos = new String[]{"Hey Santa!", "50/12/1997", "12345986723435679", "134598672345679"};

        for (String tarjeta : camposCorrectos) {
            assertTrue(Validacion.esTarjetaValida(tarjeta));
        }

        for (String tarjeta : camposIncorrectos) {
            assertFalse(Validacion.esTarjetaValida(tarjeta));
        }

    }

    @Test
    public void esRUCValido(){
        String[] camposCorrectos = new String[]{"1720254224001"};
        String[] camposIncorrectos = new String[]{"Hey Santa!", "1710254224001", "172025422402"};

        for (String ruc : camposCorrectos) {
            assertTrue(Validacion.esRUCValido(ruc));
        }

        for (String ruv : camposIncorrectos) {
            assertFalse(Validacion.esRUCValido(ruv));
        }

    }


}