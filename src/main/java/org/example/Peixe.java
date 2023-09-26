package org.example;

import java.util.Random;

public abstract class Peixe {
    protected int x, y;
    protected Aquario aquario;

    public Peixe(int x, int y, Aquario aquario) {
        this.x = x;
        this.y = y;
        this.aquario = aquario;
    }

    public abstract void mover();

    public int obterX() {
        return x;
    }

    public int obterY() {
        return y;
    }
}