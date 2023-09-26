package org.example;

import java.util.Random;

public class PeixeTipoA extends Peixe {
    private int movimentosSemComer = 0;
    private static final int RA = 5;
    private static final int MA = 3;

    public PeixeTipoA(int x, int y, Aquario aquario) {
        super(x, y, aquario);
    }

    @Override
    public void mover() {
        Random rand = new Random();
        int novoX = x + rand.nextInt(3) - 1;
        int novoY = y + rand.nextInt(3) - 1;

        if (aquario.celulaLivre(novoX, novoY)) {
            aquario.moverPeixe(this, novoX, novoY);
            x = novoX;
            y = novoY;
            movimentosSemComer++;
        }

        if (movimentosSemComer >= MA) {
            aquario.removerPeixe(this);
        }

        if (movimentosSemComer % RA == 0) {
            // Encontre uma posição adjacente livre para o novo peixe
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (aquario.celulaLivre(x + i, y + j)) {
                        PeixeTipoA novoPeixeA = new PeixeTipoA(x + i, y + j, aquario);
                        aquario.adicionarPeixe(novoPeixeA);
                        return;  // Saia após adicionar o novo peixe
                    }
                }
            }
        }
    }
}
