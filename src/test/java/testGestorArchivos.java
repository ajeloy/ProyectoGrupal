/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import manejoArchivos.GestorArchivos;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author Nadie
 */
public class testGestorArchivos {

    private GestorArchivos gestor;

    @Before
    public void setUp() {
        gestor = new GestorArchivos();
    }

    @Test
    public void testMostrarPersonas() throws IOException {
        
    }

    @Test
    public void testAcceso() throws IOException {
        boolean resultadoObtenido = gestor.autorizarAcceso("193062237", "nada","");
        boolean resultadoEsperado = true;
        assertEquals(resultadoObtenido, resultadoEsperado);
    }
    
    
    
}
