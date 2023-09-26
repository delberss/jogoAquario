package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AquarioTest {
    private Aquario aquario;

    @BeforeEach
    public void setup() {
        aquario = new Aquario(5, 5);
    }

    @Test
    public void testeAdicionarPeixe() {
        PeixeTipoA peixeA = new PeixeTipoA(2, 2, aquario);
        aquario.adicionarPeixe(peixeA);
        assertEquals(peixeA, aquario.getPeixe(2, 2));
    }

    @Test
    public void testeMoverPeixeTipoA() {
        PeixeTipoA peixeA = new PeixeTipoA(2, 2, aquario);
        aquario.adicionarPeixe(peixeA);
        peixeA.mover();
        assertNotEquals(peixeA, aquario.getPeixe(2, 2));
    }

    @Test
    public void testeMoverPeixeTipoB() {
        PeixeTipoB peixeB = new PeixeTipoB(2, 2, aquario);
        aquario.adicionarPeixe(peixeB);
        peixeB.mover();
        assertNotEquals(peixeB, aquario.getPeixe(2, 2));
    }

    @Test
    public void testePeixeTipoBMataPeixeTipoA() {
        PeixeTipoA peixeA = new PeixeTipoA(2, 3, aquario);
        PeixeTipoB peixeB = new PeixeTipoB(2, 2, aquario);
        aquario.adicionarPeixe(peixeA);
        aquario.adicionarPeixe(peixeB);
        peixeB.mover();
        assertNull(aquario.getPeixe(2, 3));
    }

    @Test
    public void testePeixeTipoAMorreDeFome() {
        PeixeTipoA peixeA = new PeixeTipoA(2, 2, aquario);
        aquario.adicionarPeixe(peixeA);
        for (int i = 0; i < 4; i++) {
            peixeA.mover();
        }
        assertNull(aquario.getPeixe(2, 2));
    }

    @Test
    public void testePeixeTipoBMorreDeFome() {
        PeixeTipoB peixeB = new PeixeTipoB(2, 2, aquario);
        aquario.adicionarPeixe(peixeB);
        for (int i = 0; i < 3; i++) {
            peixeB.mover();
        }
        assertNull(aquario.getPeixe(2, 2));
    }

}