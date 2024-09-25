import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class taller2Test {

    Object [][] registro = new Object[50][3];

    @BeforeEach
    void setUp() {
        System.out.println("Preparando la matriz para una prueba...");
        registro[0] = new Object[]{"Persona1","Soltero/a",26};
        registro[1] = new Object[]{"Persona2","Casado/a",14};
        registro[2] = new Object[]{"Persona3","Soltero/a",38};
        registro[3] = new Object[]{"Persona4","Casado/a",18};
        registro[4] = new Object[]{"Persona5","Soltero/a",17};
    }

    @AfterEach
    void tearDown() {
        System.out.println("Limpiando la matriz después de una prueba...");
        registro[0] = null;
        registro[1] = null;
        registro[2] = null;
        registro[3] = null;
        registro[4] = null;
        registro[5] = null;
    }

    @Test
    void espacioDisponible() {
        assertTrue(taller2.espacioDisponible(registro));
    }

    @Test
    void obtenerFilaVacia() {
        assertEquals(5, taller2.obtenerFilaVacia(registro));
    }

    @Test
    void personaUnica() {
        assertTrue(taller2.personaUnica(registro,"Persona7"));
        assertFalse(taller2.personaUnica(registro,"Persona1"));
    }

    @Test
    void transformarEstadoCivil() {
        assertEquals("Soltero/a",taller2.transformarEstadoCivil(1));
        assertEquals("Casado/a",taller2.transformarEstadoCivil(2));
    }

    @Test
    void escribirDatos() {
        assertEquals("Persona5",taller2.escribirDatos(registro,"Persona5","Casado/a",42,5)[5][0]);
        assertEquals("Casado/a",taller2.escribirDatos(registro,"Persona5","Casado/a",42,5)[5][1]);
        assertEquals(42,taller2.escribirDatos(registro,"Persona5","Casado/a",42,5)[5][2]);
    }

    @Test
    void cantidadMayoresDeEdad() {
        assertEquals(3,taller2.cantidadMayoresDeEdad(registro));
    }

    @Test
    void cantidadMenoresDeEdad() {
        assertEquals(2,taller2.cantidadMenoresDeEdad(registro));
    }

}