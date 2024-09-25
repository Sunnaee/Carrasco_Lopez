import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class taller2Test {

    Object [][] registroPruebas = new Object[50][3];

    @BeforeEach
    void setUp() {
        registroPruebas[0] = new Object[]{"Martin", "Casado/a", 20};
        registroPruebas[1] = new Object[]{"Sabrina", "Casado/a", 20};
        registroPruebas[2] = new Object[]{"Emilio", "Soltero/a", 70};
        registroPruebas[3] = new Object[]{"David", "Casado/a", 100};

    }

    @Test
    void cantidadAdultoMayor() {
        assertEquals(2, taller2.cantidadAdultoMayor(registroPruebas));
    }

    @Test
    void cantidadDeSolteros() {
        assertEquals(1, taller2.cantidadDeSolteros(registroPruebas));
    }

    @Test
    void cantidadDeCasados() {
        assertEquals(3, taller2.cantidadDeCasados(registroPruebas));
    }
}