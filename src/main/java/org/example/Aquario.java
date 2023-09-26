package org.example;

public class Aquario {
    private Peixe[][] matriz;
    private int M, N;

    public Aquario(int M, int N) {
        this.M = M;
        this.N = N;
        matriz = new Peixe[M][N];
    }

    public void adicionarPeixe(Peixe peixe) {
        matriz[peixe.obterX()][peixe.obterY()] = peixe;
    }

    public boolean celulaLivre(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N && matriz[x][y] == null;
    }

    public PeixeTipoA encontrarPeixeAProximo(int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i >= 0 && x + i < M && y + j >= 0 && y + j < N && matriz[x + i][y + j] instanceof PeixeTipoA) {
                    return (PeixeTipoA) matriz[x + i][y + j];
                }
            }
        }
        return null;
    }

    public void moverPeixe(Peixe peixe, int novoX, int novoY) {
        matriz[peixe.obterX()][peixe.obterY()] = null;
        matriz[novoX][novoY] = peixe;
    }

    public void removerPeixe(Peixe peixe) {
        matriz[peixe.obterX()][peixe.obterY()] = null;
    }

    public void iteracao() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matriz[i][j] != null) {
                    matriz[i][j].mover();
                }
            }
        }
    }

    public Peixe getPeixe(int x, int y) {
        return matriz[x][y];
    }
}