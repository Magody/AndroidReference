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
    /*@Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }*/

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
}