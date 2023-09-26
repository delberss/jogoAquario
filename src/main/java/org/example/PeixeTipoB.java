package org.example;

import java.util.Random;

public class PeixeTipoB extends Peixe {
    private int peixesComidos = 0;
    private static final int RB = 4;
    private static final int MB = 2;

    public PeixeTipoB(int x, int y, Aquario aquario) {
        super(x, y, aquario);
    }

    @Override
    public void mover() {
        PeixeTipoA peixeA = aquario.encontrarPeixeAProximo(x, y);
        if (peixeA != null) {
            aquario.removerPeixe(peixeA);
            peixesComidos++;
        } else {
            Random rand = new Random();
            int novoX = x + rand.nextInt(3) - 1;
            int novoY = y + rand.nextInt(3) - 1;
            if (aquario.celulaLivre(novoX, novoY)) {
                aquario.moverPeixe(this, novoX, novoY);
                x = novoX;
                y = novoY;
            }
        }

        if (peixesComidos == RB) {
            // Encontre uma posição adjacente livre para o novo peixe
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (aquario.celulaLivre(x + i, y + j)) {
                        PeixeTipoB novoPeixeB = new PeixeTipoB(x + i, y + j, aquario);
                        aquario.adicionarPeixe(novoPeixeB);
                        peixesComidos = 0;  // Redefina o contador
                        return;  // Saia após adicionar o novo peixe
                    }
                }
            }
        }
    }
}